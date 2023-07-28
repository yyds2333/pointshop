package com.powernode.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.config.ESConfig;
import com.powernode.constant.ESConstant;
import com.powernode.domain.Prod;
import com.powernode.model.ProdES;
import com.powernode.service.ImportService;
import com.powernode.service.ProdService;
import com.powernode.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ImportServiceImpl implements ImportService, CommandLineRunner {

    @Autowired
    private ProdService prodService;

    @Autowired
    private ESConfig esConfig;

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    private Date t1; // 开始时间

    /**
     * 全量导入
     */
    @Override
    public void importAll() {
        // 查询索引是否存在
        CountRequest countRequest = new CountRequest(ESConstant.PROD_ES_INDEX);

        CountResponse countResponse = null;

        try {
            countResponse = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            System.err.println("索引不存在，导入开始");
        }

        // 获取是否导入成功
        if (countResponse != null && countResponse.getCount() > 0) {
            System.out.println("索引已存在，无需导入");
            t1 = new Date();
            return;
        }

        System.out.println("开始全量导入");
        Integer count = prodService.selectCount(null, null);
        if (count <= 0) {
            // 没有记录需要导入，则返回
            return;
        }
        // 获取每页大小
        Integer size = esConfig.getSize();
        // 计算总页数
        int pageCount = count % size == 0 ? count / size : (count / size + 1);
        // 使用多线程计数器导入
        CountDownLatch countDownLatch = new CountDownLatch(pageCount);
        // 循环导入每页数据
        for (int i = 1; i < pageCount; i++) {
            final int curren = i;
            ThreadPoolUtil.poolExecutor.submit(() -> {
                // 引用导入方法进行导入
                importES(curren, size, null, null);

                // 计数器
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await(10, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t1 = new Date();
        System.out.println("导入完成");
    }


    /**
     * 增量导入,每隔2分钟或多长时间执行一次增量导入
     */
    @Override
    @Scheduled(fixedDelay = 120 * 1000, initialDelay = 120 * 1000)
    public void importUpdate() {
        Date t2 = new Date();
        // 获取总记录数
        Integer count = prodService.selectCount(t1, t2);
        // 开始计时
        if (count <= 0) {
            t1 = t2;
            return;
        }
        // 获取每页大小
        Integer size = esConfig.getSize();
        // 计算总页数
        int pageCount = count % size == 0 ? count / size : (count / size + 1);
        // 使用多线程计数器导入
        CountDownLatch countDownLatch = new CountDownLatch(pageCount);
        // 通过线程完成导入
        for (int i = 1; i < pageCount; i++) {
            final int curren = i;
            ThreadPoolUtil.poolExecutor.submit(() -> {
                // 引用导入方法进行导入
                importES(curren, size, null, null);
                System.out.println("开始导入第" + curren + "页数据");
                // 计数器
                countDownLatch.countDown();
            });
        }


        try {
            countDownLatch.await(10, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t1 = new Date();
        System.out.println("增量导入开始计时" + t1);
    }

    @Override
    public void run(String... args) throws Exception {
        importAll();
    }

    /**
     * 往Es中导入数据
     *
     * @param curren
     * @param size
     * @param t1
     * @param t2
     */
    private void importES(int curren, Integer size, Date t1, Date t2) {
        // 创建分页对象
        Page<Prod> page = new Page<>(curren, size);
        // 查询数据
        List<ProdES> prodESList = prodService.loadProdESwithPage(page, t1, t2);
        // ES批量请求对象
        BulkRequest bulkRequest = new BulkRequest();
        // 循环将要导入的对象添加到请求中
        prodESList.forEach(prodES -> {
            // 设置prodId为主键，创建索引
            IndexRequest indexRequest = new IndexRequest(ESConstant.PROD_ES_INDEX).id(prodES.getProdId().toString());
            // 将数据转成JSON添加到索引中
            indexRequest.source(JSON.toJSONString(prodES), XContentType.JSON);
            // 添加到批量请求中
            bulkRequest.add(indexRequest);
        });
        // 批量导入
        try {
            restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
