package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
    * 定时任务
    */
@TableName(value = "schedule_job")
public class ScheduleJob {
    /**
     * 任务id
     */
    @TableId(value = "job_id", type = IdType.INPUT)
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
     * cron表达式
     */
    @TableField(value = "cron_expression")
    private String cronExpression;

    /**
     * 任务状态  0：正常  1：暂停
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    public static final String COL_JOB_ID = "job_id";

    public static final String COL_BEAN_NAME = "bean_name";

    public static final String COL_METHOD_NAME = "method_name";

    public static final String COL_PARAMS = "params";

    public static final String COL_CRON_EXPRESSION = "cron_expression";

    public static final String COL_STATUS = "status";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATE_TIME = "create_time";

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
     * 获取cron表达式
     *
     * @return cron_expression - cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 设置cron表达式
     *
     * @param cronExpression cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * 获取任务状态  0：正常  1：暂停
     *
     * @return status - 任务状态  0：正常  1：暂停
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置任务状态  0：正常  1：暂停
     *
     * @param status 任务状态  0：正常  1：暂停
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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