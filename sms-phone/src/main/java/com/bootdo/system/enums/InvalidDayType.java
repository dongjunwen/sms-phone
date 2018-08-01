package com.bootdo.system.enums;

/**
 * @Author:luiz
 * @Date: 2018/7/31 13:37
 * @Descripton:
 * 生效类型
 * @Modify :
 **/
public enum InvalidDayType {
    MIN("MIN","分钟"),
    HOU("HOU","小时"),
    DAY("DAY","天"),
    MON("MON","月"),
    YEA("YEA","年"),
    ;

    InvalidDayType(String code, String name) {
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

    public static InvalidDayType parse(String invalidType) {
        for(InvalidDayType invalidDayTypeEnum:InvalidDayType.values()){
            if(invalidDayTypeEnum.getCode().equals(invalidType)){
                return invalidDayTypeEnum;
            }
        }
        return null;
    }
}
