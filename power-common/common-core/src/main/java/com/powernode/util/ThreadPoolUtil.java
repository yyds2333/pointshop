package com.powernode.util;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程工具类，用于异步执行数据库插入工作
 *
 * 线程数量
 * cpu可用核数
 * 超时等待时间
 */
public class ThreadPoolUtil {

    public static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,Runtime.getRuntime().availableProcessors()*2,30,
            TimeUnit.SECONDS,new LinkedBlockingDeque<>(10000), Executors.defaultThreadFactory(), // 线程创建工厂
            new ThreadPoolExecutor.AbortPolicy());
}
