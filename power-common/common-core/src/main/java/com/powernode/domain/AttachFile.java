package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value = "attach_file")
public class AttachFile {
    @TableId(value = "file_id", type = IdType.INPUT)
    private Long fileId;

    /**
     * 文件路径
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 文件类型
     */
    @TableField(value = "file_type")
    private String fileType;

    /**
     * 文件大小
     */
    @TableField(value = "file_size")
    private Integer fileSize;

    /**
     * 上传时间
     */
    @TableField(value = "upload_time")
    private Date uploadTime;

    /**
     * 文件关联的表主键id
     */
    @TableField(value = "file_join_id")
    private Long fileJoinId;

    /**
     * 文件关联表类型：1 商品表  FileJoinType
     */
    @TableField(value = "file_join_type")
    private Byte fileJoinType;

    public static final String COL_FILE_ID = "file_id";

    public static final String COL_FILE_PATH = "file_path";

    public static final String COL_FILE_TYPE = "file_type";

    public static final String COL_FILE_SIZE = "file_size";

    public static final String COL_UPLOAD_TIME = "upload_time";

    public static final String COL_FILE_JOIN_ID = "file_join_id";

    public static final String COL_FILE_JOIN_TYPE = "file_join_type";

    /**
     * @return file_id
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取文件路径
     *
     * @return file_path - 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置文件路径
     *
     * @param filePath 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取文件类型
     *
     * @return file_type - 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置文件类型
     *
     * @param fileType 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取文件大小
     *
     * @return file_size - 文件大小
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * 设置文件大小
     *
     * @param fileSize 文件大小
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取上传时间
     *
     * @return upload_time - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * 获取文件关联的表主键id
     *
     * @return file_join_id - 文件关联的表主键id
     */
    public Long getFileJoinId() {
        return fileJoinId;
    }

    /**
     * 设置文件关联的表主键id
     *
     * @param fileJoinId 文件关联的表主键id
     */
    public void setFileJoinId(Long fileJoinId) {
        this.fileJoinId = fileJoinId;
    }

    /**
     * 获取文件关联表类型：1 商品表  FileJoinType
     *
     * @return file_join_type - 文件关联表类型：1 商品表  FileJoinType
     */
    public Byte getFileJoinType() {
        return fileJoinType;
    }

    /**
     * 设置文件关联表类型：1 商品表  FileJoinType
     *
     * @param fileJoinType 文件关联表类型：1 商品表  FileJoinType
     */
    public void setFileJoinType(Byte fileJoinType) {
        this.fileJoinType = fileJoinType;
    }
}