package com.bootdo.system.enums;

/**
 * @Author:luiz
 * @Date: 2018/7/31 13:37
 * @Descripton:
 *  生效状态 0:未使用 1:已使用 2:已过期
 * @Modify :
 **/
public enum RoleCodeEnum {
    ADMIN("ADMIN","管理员"),
    NORMAL("NORMAL","普通用户"),
    PROXY("PROXY","代理商");

    RoleCodeEnum(String code, String name) {
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

    public static RoleCodeEnum parse(String orderStatus) {
        for(RoleCodeEnum orderStatusEnum: RoleCodeEnum.values()){
                if(orderStatusEnum.getCode().equals(orderStatus)) return orderStatusEnum;
        }
        return null;
    }
}
