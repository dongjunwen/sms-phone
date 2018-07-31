package com.bootdo.system.domain;

import java.util.List;

/**
 * @Author:luiz
 * @Date: 2018/7/31 18:48
 * @Descripton:
 * @Modify :
 **/
public class SmsBean {
    private String orderNo;
    //手机号码
    private String phoneNum;
    private List<ConfigDO> configDOList;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<ConfigDO> getConfigDOList() {
        return configDOList;
    }

    public void setConfigDOList(List<ConfigDO> configDOList) {
        this.configDOList = configDOList;
    }
}
