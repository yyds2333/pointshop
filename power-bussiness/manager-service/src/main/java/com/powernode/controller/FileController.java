package com.powernode.controller;

import com.alibaba.fastjson.JSON;
import com.powernode.config.FileConfig;
import com.powernode.model.Result;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@RestController
@Api(tags = "文件管理API接口")
public class FileController {

    @Autowired
    private FileConfig fileConfig;

    @PostMapping("/admin/file/upload/element")
    public Result<String> fileUpload(MultipartFile file ){
        // 构建一个带指定Region对象的配置类
        Configuration configuration = new Configuration(Region.huanan());
        configuration.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;
        UploadManager uploadManager = new UploadManager();
        //生成上传凭证
        String accesskey = fileConfig.getAk();
        String secretKey = fileConfig.getSk();
        String bucket = fileConfig.getBucket();
        // 不指定文件的key，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accesskey,secretKey);

        try{
            byte[] bytes = new byte[0];
            bytes = file.getBytes();
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(bis, key, upToken,null,null);
            // 解析上传成功的结果
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            // 拼接文件名
            String filename = fileConfig.getDomain() + putRet.key;
            return Result.success("图片上传成功",filename);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务内部错误，上传失败");
        }
    }
}
