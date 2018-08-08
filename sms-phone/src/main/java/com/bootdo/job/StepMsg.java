package com.bootdo.job;

/**
 * @Author:luiz
 * @Date: 2018/8/8 17:13
 * @Descripton:
 * @Modify :
 **/
public class StepMsg {
    //是否使用了第一步
    private boolean useStep1=false;
    private String cookieStr;
    private String paramStr;

    public boolean isUseStep1() {
        return useStep1;
    }

    public void setUseStep1(boolean useStep1) {
        this.useStep1 = useStep1;
    }

    public String getCookieStr() {
        return cookieStr;
    }

    public void setCookieStr(String cookieStr) {
        this.cookieStr = cookieStr;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }
}
