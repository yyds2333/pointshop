package com.powernode.controller;

import com.powernode.model.Result;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "文件管理API接口")
public class FileController {

    @PostMapping("/admin/file/upload/element")
    public Result<String> fileUpload(MultipartFile file ){
        Configuration configuration = new Configuration(Region.huanan());



        return ;
    }
}
