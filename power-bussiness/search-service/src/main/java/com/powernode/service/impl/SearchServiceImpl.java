package com.powernode.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.model.ProdES;
import com.powernode.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 根据搜索栏的数据进行模糊查询
     * @param prodName
     * @param current
     * @param size
     * @param sort
     * @return
     */
    @Override
    public Page<ProdES> getSearchProdList(String prodName, Integer current, Integer size, Integer sort) {
        Page<ProdES> prodESPage = new Page<>(current,size);
        log.info(prodName);
        // 模糊字段搜索
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("prodName",prodName);
        // 设置高亮.prodName字段高亮显示
        HighlightBuilder.Field field = new HighlightBuilder.Field("prodName");
        field.preTags("<span style='color:red'>");
        field.postTags("</span>");
        // 构建一个查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQueryBuilder)
                .withPageable(PageRequest.of(current-1,size))
                .withHighlightFields(field)
                .withSorts(prodSort(sort)).build();


        SearchHits<ProdES> searchHits = elasticsearchRestTemplate.search(searchQuery, ProdES.class);
        //处理高亮
        searchHits.forEach(searchHit->{
            ProdES prodES = searchHit.getContent();
            // 获取查寻结果中的高亮字段
            List<String> highlightField = searchHit.getHighlightField("prodName");
            // 将高亮字段设置给prodES
            prodES.setProdName(highlightField.get(0));
        });

        // 设置总条数
        prodESPage.setTotal(searchHits.getTotalHits());
        // 将searchHits中的content取出来放到prodES的集合中
        List<ProdES> collect = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        // 将上述集合设置到Page中返回给前端
        prodESPage.setRecords(collect);
        return prodESPage;
    }

    /**
     * 根据标签获取商品
     * @param tagId
     * @param size
     * @param current
     * @return
     */
    @Override
    public Page<ProdES> loadProdByTag(Long tagId, Integer size, Integer current) {
        Page<ProdES> esPage = new Page<>(current,size);
        // 创建查询条件
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("tagList",tagId);
        // 组合查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQueryBuilder)
                .withPageable(PageRequest.of(current-1,size))
                .build();

        SearchHits<ProdES> searchHits = elasticsearchRestTemplate.search(searchQuery, ProdES.class);

        List<ProdES> collect = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        esPage.setRecords(collect);
        esPage.setTotal(searchHits.getTotalHits());
        return esPage;
    }

    /**
     * 根据产品种类获取产品数据
     * @param cateGoryId
     * @param current
     * @return
     */
    @Override
    public Page<ProdES> loadProdByCategoryId(Long cateGoryId, Integer current) {
        Page<ProdES> esPage = new Page<>(current,5);
        // 创建查询条件
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("categoryId",cateGoryId);
        // 组合查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQueryBuilder)
                .withPageable(PageRequest.of(current-1,5))
                .build();

        SearchHits<ProdES> searchHits = elasticsearchRestTemplate.search(searchQuery, ProdES.class);

        List<ProdES> collect = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        esPage.setRecords(collect);
        esPage.setTotal(searchHits.getTotalHits());
        return esPage;
    }

    /**
     * 根据分页信息和商品ID获取商品列表
     * @param page
     * @param prodIds
     * @return
     */
    @Override
    public Page<ProdES> loadProdPageByProdIds(Page<Long> page, List<Long> prodIds) {
        Integer current = (int) (page.getCurrent()-1);
        Integer size = (int) page.getSize();
        Page<ProdES> prodESPage = new Page<>(current+1,size);
        TermsQueryBuilder prodQuery = QueryBuilders.termsQuery("prodId", prodIds);
        // 组合查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(prodQuery)
                .withPageable(PageRequest.of(current,size))
                .build();
        SearchHits<ProdES> search = elasticsearchRestTemplate.search(searchQuery, ProdES.class);

        List<ProdES> collect = search.stream().map(SearchHit::getContent).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)){
            return null;
        }
        prodESPage.setRecords(collect);
        prodESPage.setTotal(search.getTotalHits());
        return prodESPage;
    }

    // 排序字段设置
    private SortBuilder prodSort(Integer sort){
        switch (sort){
            case 0:// 综合排序
                return SortBuilders.fieldSort("positiveRating").order(SortOrder.DESC);
            case 1:// 销量
                return SortBuilders.fieldSort("soldNum").order(SortOrder.DESC);
            case 2:// 价格
                return SortBuilders.fieldSort("price").order(SortOrder.DESC);
            default:
                throw new IllegalArgumentException("排序方法错误");
        }
    }
}
