package com.powernode.aop;

import com.alibaba.fastjson.JSON;
import com.powernode.ann.MyLog;
import com.powernode.domain.SysLog;
import com.powernode.model.Result;
import com.powernode.service.SysLogService;
import com.powernode.util.AuthUtil;
import com.powernode.util.ThreadPoolUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class MyLogAdvice {

    @Autowired
    private SysLogService sysLogService;

    // 定义一个方法其作用是 具有MyLog的方法都是目标方法
    @Around(value="@annotation(com.powernode.ann.MyLog)")
    public Object doLogAround(ProceedingJoinPoint joinPoint){
        // 通过反射 获取方法签名
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        // 调用反射方法实现
        Method method = methodSignature.getMethod();
        // 获取类名
        String typeName = method.getDeclaringClass().getTypeName();
        String methodName = typeName + "." + method.getName();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        String paramStr = ObjectUtils.isEmpty(args) ? "" : JSON.toJSONString(args);
        // 用户ID
        Long userID = AuthUtil.getSysUserId();
        // 获取具体操作说明
        String oprate = method.getAnnotation(MyLog.class).oprate();
        // 获取IP地址
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getRemoteHost();
        // 开始时间
        long startMill = System.currentTimeMillis();
        // 调用目标方法
        Object result = null;
        try{
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 结束时间
        long lastMill = System.currentTimeMillis();

        // 计算出时间间隔
        long mill = lastMill - startMill;

        // 插入信息到Log表中
        SysLog sysLog = SysLog.builder().createDate(new Date()).ip(ip).method(methodName).operation(oprate)
                .params(paramStr).userId(userID).time(mill).build();
        // 使用多线程工具类将 sysLog异步提交到数据库
        ThreadPoolUtil.poolExecutor.submit(()->{
            boolean save = sysLogService.save(sysLog);
            System.out.println("日志保存: "+ save);
        });
        return result;
    }
}
