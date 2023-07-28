package com.powernode.exception;

import com.powernode.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice  // 当人已请求控制异常产生时，会自动统一处理，针对ProdException
public class ProdErrorController {

    // 当产生Value的异常时进行处理
    @ExceptionHandler(value = ProdException.class)
    public Result<String> prodHandler(ProdException prodException){
        log.error("商品出现异常"  + prodException);
        return Result.failure(500,"商品服务出现异常:" + prodException);
    }
}
