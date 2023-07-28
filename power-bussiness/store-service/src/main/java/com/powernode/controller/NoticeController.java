package com.powernode.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.powernode.domain.Notice;
import com.powernode.model.Result;
import com.powernode.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/notice")
@Api("商店公告")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 加载公告
     * @param page
     * @param notice
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页获取公告")
    public Result<Page<Notice>> loadNoticePage(Page<Notice> page,Notice notice){
        return Result.success("获取公告成功",noticeService.loadNoticeListByPage(page,notice));
    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @PostMapping
    @ApiOperation("添加公告")
    public Result<Integer> addNotice(Notice notice){
        return Result.success("添加成功",noticeService.addNotice(notice));
    }

    @GetMapping("/info/{id}")
    @ApiOperation("获取需要修改的公告")
    public Result<Notice> getNoticeById(@PathVariable Long id){
        return ObjectUtils.isEmpty(id)?Result.failure(HttpStatus.SC_INTERNAL_SERVER_ERROR,"参数错误"):Result.success("获取数据成功",noticeService.getById(id));
    }

    @PutMapping
    @ApiOperation("修改公告")
    public Result<Integer> updateNotice(@RequestBody Notice notice){
        return Result.success("修改公告成功",noticeService.updateNotice(notice));
    }

    /**
     * 小程序获取公告列表
     */
    @GetMapping("/topNoticeList")
    @ApiOperation("小程序获取置顶公告列表")
    public Result<List<Notice>> getTopNoticeList(){
        return Result.success("获取置顶公告列表成功",noticeService.loadMallNotice());
    }

//    @GetMapping("/noticeList")
//    @ApiOperation("小程序获取公告列表")
//    public Result<List<Notice>> getNoticeList(){
//        return Result.success("获取公告列表成功",noticeService.loadGenMallNotice());
//    }


}
