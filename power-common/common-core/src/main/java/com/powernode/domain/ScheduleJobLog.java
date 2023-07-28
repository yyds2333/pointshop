package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
    * 定时任务日志
    */
@TableName(value = "schedule_job_log")
public class ScheduleJobLog  implements Serializable {
    /**
     * 任务日志id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    /**
     * 任务id
     */
    @TableField(value = "job_id")
    private Long jobId;

    /**
     * spring bean名称
     */
    @TableField(value = "bean_name")
    private String beanName;

    /**
     * 方法名
     */
    @TableField(value = "method_name")
    private String methodName;

    /**
     * 参数
     */
    @TableField(value = "params")
    private String params;

    /**
     * 任务状态    0：成功    1：失败
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 失败信息
     */
    @TableField(value = "error")
    private String error;

    /**
     * 耗时(单位：毫秒)
     */
    @TableField(value = "times")
    private Integer times;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_LOG_ID = "log_id";

    public static final String COL_JOB_ID = "job_id";

    public static final String COL_BEAN_NAME = "bean_name";

    public static final String COL_METHOD_NAME = "method_name";

    public static final String COL_PARAMS = "params";

    public static final String COL_STATUS = "status";

    public static final String COL_ERROR = "error";

    public static final String COL_TIMES = "times";

    public static final String COL_CREATE_TIME = "create_time";

    /**
     * 获取任务日志id
     *
     * @return log_id - 任务日志id
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * 设置任务日志id
     *
     * @param logId 任务日志id
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * 获取任务id
     *
     * @return job_id - 任务id
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 设置任务id
     *
     * @param jobId 任务id
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取spring bean名称
     *
     * @return bean_name - spring bean名称
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 设置spring bean名称
     *
     * @param beanName spring bean名称
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 获取方法名
     *
     * @return method_name - 方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置方法名
     *
     * @param methodName 方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取参数
     *
     * @return params - 参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置参数
     *
     * @param params 参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取任务状态    0：成功    1：失败
     *
     * @return status - 任务状态    0：成功    1：失败
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置任务状态    0：成功    1：失败
     *
     * @param status 任务状态    0：成功    1：失败
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取失败信息
     *
     * @return error - 失败信息
     */
    public String getError() {
        return error;
    }

    /**
     * 设置失败信息
     *
     * @param error 失败信息
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 获取耗时(单位：毫秒)
     *
     * @return times - 耗时(单位：毫秒)
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 设置耗时(单位：毫秒)
     *
     * @param times 耗时(单位：毫秒)
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}