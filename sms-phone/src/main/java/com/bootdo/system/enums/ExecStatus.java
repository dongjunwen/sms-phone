package com.bootdo.system.enums;

/**
 * @Author:luiz
 * @Date: 2018/7/31 13:37
 * @Descripton:
 *  运行状态 0:已停止 1:运行中
 * @Modify :
 **/
public enum ExecStatus {
    STOP(0,"已停止"),
    PROCESS(1,"运行中");

    ExecStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
