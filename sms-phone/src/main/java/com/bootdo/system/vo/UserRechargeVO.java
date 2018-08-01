package com.bootdo.system.vo;


import java.math.BigDecimal;

/**
 * @author gaoyuzhe
 * @date 2017/12/15.
 */
public class UserRechargeVO {
    //用户编号
    private Long userId;
    //充值金额
    private BigDecimal rechargeAmt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getRechargeAmt() {
        return rechargeAmt;
    }

    public void setRechargeAmt(BigDecimal rechargeAmt) {
        this.rechargeAmt = rechargeAmt;
    }
}
