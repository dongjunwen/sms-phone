package com.bootdo.system.vo;

import com.bootdo.system.domain.SmsDO;

import java.util.List;

public class CustResultVo {
    private String sellerQq;
    private String sellerWeiXin;
    private String orderNo;
    private boolean ifShow;//是否激活
    private String orderStatus;
    private String orderStatusName;
    private long remainDay;
    private String useTime;
    private String unvalidTime;

    private List<SmsDO> smsDOS;
    public String getSellerQq() {
        return sellerQq;
    }

    public void setSellerQq(String sellerQq) {
        this.sellerQq = sellerQq;
    }

    public String getSellerWeiXin() {
        return sellerWeiXin;
    }

    public void setSellerWeiXin(String sellerWeiXin) {
        this.sellerWeiXin = sellerWeiXin;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public boolean isIfShow() {
        return ifShow;
    }

    public void setIfShow(boolean ifShow) {
        this.ifShow = ifShow;
    }

    public long getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(long remainDay) {
        this.remainDay = remainDay;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getUnvalidTime() {
        return unvalidTime;
    }

    public void setUnvalidTime(String unvalidTime) {
        this.unvalidTime = unvalidTime;
    }

    public List<SmsDO> getSmsDOS() {
        return smsDOS;
    }

    public void setSmsDOS(List<SmsDO> smsDOS) {
        this.smsDOS = smsDOS;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
}
