package com.powernode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName(value = "transfee")
public class Transfee  implements Serializable {
    /**
     * 运费项id
     */
    @TableId(value = "transfee_id", type = IdType.AUTO)
    private Long transfeeId;

    /**
     * 运费模板id
     */
    @TableField(value = "transport_id")
    private Long transportId;

    /**
     * 续件数量
     */
    @TableField(value = "continuous_piece")
    private BigDecimal continuousPiece;

    /**
     * 首件数量
     */
    @TableField(value = "first_piece")
    private BigDecimal firstPiece;

    /**
     * 续件费用
     */
    @TableField(value = "continuous_fee")
    private BigDecimal continuousFee;

    /**
     * 首件费用
     */
    @TableField(value = "first_fee")
    private BigDecimal firstFee;

    public static final String COL_TRANSFEE_ID = "transfee_id";

    public static final String COL_TRANSPORT_ID = "transport_id";

    public static final String COL_CONTINUOUS_PIECE = "continuous_piece";

    public static final String COL_FIRST_PIECE = "first_piece";

    public static final String COL_CONTINUOUS_FEE = "continuous_fee";

    public static final String COL_FIRST_FEE = "first_fee";

    /**
     * 获取运费项id
     *
     * @return transfee_id - 运费项id
     */
    public Long getTransfeeId() {
        return transfeeId;
    }

    /**
     * 设置运费项id
     *
     * @param transfeeId 运费项id
     */
    public void setTransfeeId(Long transfeeId) {
        this.transfeeId = transfeeId;
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
     * 获取续件数量
     *
     * @return continuous_piece - 续件数量
     */
    public BigDecimal getContinuousPiece() {
        return continuousPiece;
    }

    /**
     * 设置续件数量
     *
     * @param continuousPiece 续件数量
     */
    public void setContinuousPiece(BigDecimal continuousPiece) {
        this.continuousPiece = continuousPiece;
    }

    /**
     * 获取首件数量
     *
     * @return first_piece - 首件数量
     */
    public BigDecimal getFirstPiece() {
        return firstPiece;
    }

    /**
     * 设置首件数量
     *
     * @param firstPiece 首件数量
     */
    public void setFirstPiece(BigDecimal firstPiece) {
        this.firstPiece = firstPiece;
    }

    /**
     * 获取续件费用
     *
     * @return continuous_fee - 续件费用
     */
    public BigDecimal getContinuousFee() {
        return continuousFee;
    }

    /**
     * 设置续件费用
     *
     * @param continuousFee 续件费用
     */
    public void setContinuousFee(BigDecimal continuousFee) {
        this.continuousFee = continuousFee;
    }

    /**
     * 获取首件费用
     *
     * @return first_fee - 首件费用
     */
    public BigDecimal getFirstFee() {
        return firstFee;
    }

    /**
     * 设置首件费用
     *
     * @param firstFee 首件费用
     */
    public void setFirstFee(BigDecimal firstFee) {
        this.firstFee = firstFee;
    }
}