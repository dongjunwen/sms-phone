package com.bootdo.system.enums;

/**
 * @Author:luiz
 * @Date: 2018/7/31 13:37
 * @Descripton:
 *  生效状态 0:未使用 1:已使用 2:已过期
 * @Modify :
 **/
public enum OrderStatus {
    INIT("0","未使用"),
    USED("1","已使用"),
    UNUSED("0","已过期");

    OrderStatus(String code, String name) {
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
}
