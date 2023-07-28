package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName(value = "transfee_free")
public class TransfeeFree  implements Serializable {
    /**
     * 指定条件包邮项id
     */
    @TableId(value = "transfee_free_id", type = IdType.AUTO)
    private Long transfeeFreeId;

    /**
     * 运费模板id
     */
    @TableField(value = "transport_id")
    private Long transportId;

    /**
     * 包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     */
    @TableField(value = "free_type")
    private Byte freeType;

    /**
     * 需满金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 包邮x件/重量/体积
     */
    @TableField(value = "piece")
    private BigDecimal piece;

    public static final String COL_TRANSFEE_FREE_ID = "transfee_free_id";

    public static final String COL_TRANSPORT_ID = "transport_id";

    public static final String COL_FREE_TYPE = "free_type";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_PIECE = "piece";

    /**
     * 获取指定条件包邮项id
     *
     * @return transfee_free_id - 指定条件包邮项id
     */
    public Long getTransfeeFreeId() {
        return transfeeFreeId;
    }

    /**
     * 设置指定条件包邮项id
     *
     * @param transfeeFreeId 指定条件包邮项id
     */
    public void setTransfeeFreeId(Long transfeeFreeId) {
        this.transfeeFreeId = transfeeFreeId;
    }

    /**
     * 获取运费模板id
     *
     * @return transport_id - 运费模板id
     */
    public Long getTransportId() {
        return transportId;
    }

    /**
     * 设置运费模板id
     *
     * @param transportId 运费模板id
     */
    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    /**
     * 获取包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     *
     * @return free_type - 包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     */
    public Byte getFreeType() {
        return freeType;
    }

    /**
     * 设置包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     *
     * @param freeType 包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮）
     */
    public void setFreeType(Byte freeType) {
        this.freeType = freeType;
    }

    /**
     * 获取需满金额
     *
     * @return amount - 需满金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置需满金额
     *
     * @param amount 需满金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取包邮x件/重量/体积
     *
     * @return piece - 包邮x件/重量/体积
     */
    public BigDecimal getPiece() {
        return piece;
    }

    /**
     * 设置包邮x件/重量/体积
     *
     * @param piece 包邮x件/重量/体积
     */
    public void setPiece(BigDecimal piece) {
        this.piece = piece;
    }
}