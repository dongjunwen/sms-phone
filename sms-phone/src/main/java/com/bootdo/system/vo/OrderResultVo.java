package com.bootdo.system.vo;

import java.util.Date;

/**
 * @Author:luiz
 * @Date: 2018/8/1 11:12
 * @Descripton:
 * @Modify :
 **/
public class OrderResultVo {
    //主键ID
    private Integer id;
    //订单号(卡密)
    private String orderNo;
    //名称
    private String orderName;
    //生效状态 0:未使用 1:已使用
    private String invalidStatus;

    private String invalidStatusName;
    //生效天数
    private Integer invalidDays;
    //生效类型
    private String invalidType;
    private String invalidTypeName;
    //创建时间
    private Date createTime;
    //使用时间
    private Date useTime;
    //失效时间
    private Date unvalidTime;
    //使用人
    private Long useUserId;
    private String useUserName;
    private String useUserQq;
    //拥有人
    private Long ownerUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getInvalidStatus() {
        return invalidStatus;
    }

    public void setInvalidStatus(String invalidStatus) {
        this.invalidStatus = invalidStatus;
    }

    public String getInvalidStatusName() {
        return invalidStatusName;
    }

    public void setInvalidStatusName(String invalidStatusName) {
        this.invalidStatusName = invalidStatusName;
    }

    public Integer getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(Integer invalidDays) {
        this.invalidDays = invalidDays;
    }

    public String getInvalidType() {
        return invalidType;
    }

    public void setInvalidType(String invalidType) {
        this.invalidType = invalidType;
    }

    public String getInvalidTypeName() {
        return invalidTypeName;
    }

    public void setInvalidTypeName(String invalidTypeName) {
        this.invalidTypeName = invalidTypeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getUnvalidTime() {
        return unvalidTime;
    }

    public void setUnvalidTime(Date unvalidTime) {
        this.unvalidTime = unvalidTime;
    }

    public Long getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(Long useUserId) {
        this.useUserId = useUserId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getUseUserName() {
        return useUserName;
    }

    public void setUseUserName(String useUserName) {
        this.useUserName = useUserName;
    }

    public String getUseUserQq() {
        return useUserQq;
    }

    public void setUseUserQq(String useUserQq) {
        this.useUserQq = useUserQq;
    }
}
