package com.powernode.aop;

import com.powernode.model.Result;
import com.powernode.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogAdvice {

    @Autowired
    private SysLogService sysLogService;

    // 定义一个方法其作用是 具有MyLog的方法都是目标方法
    @Around(value="@annotation(com.powernode.ann.MyLog)")
    public Object doLogAround(ProceedingJoinPoint joinPoint){

        Result result = new Result();
        return result;
    }
}
