package com.bootdo.system.enums;

/**
 * @Author:luiz
 * @Date: 2018/7/31 13:37
 * @Descripton:
 *  生效状态 0:生效 1:失效
 * @Modify :
 **/
public enum InvalidStatus {
    VALID("0","生效"),
    UNVALID("1","失效");

    InvalidStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static InvalidStatus parse(String orderStatus) {
        for(InvalidStatus orderStatusEnum: InvalidStatus.values()){
                if(orderStatusEnum.getCode().equals(orderStatus)) return orderStatusEnum;
        }
        return null;
    }
}
