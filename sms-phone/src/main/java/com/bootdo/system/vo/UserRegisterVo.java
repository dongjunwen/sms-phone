package com.bootdo.system.vo;

/**
 * @Author:luiz
 * @Date: 2018/8/6 13:39
 * @Descripton:
 * @Modify :
 **/
public class UserRegisterVo {
    //用户编号
    private String loginNo;
    //登录密码
    private String loginPass1;
    //确认登录密码
    private String loginPass2;
    //昵称
    private String nickName;
    //账号邮箱
    private String userEmail;
    //QQ
    private String userQq;
    //微信
    private String userWeiXin;
    //邀请码
    private String invitedCode;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getLoginPass1() {
        return loginPass1;
    }

    public void setLoginPass1(String loginPass1) {
        this.loginPass1 = loginPass1;
    }

    public String getLoginPass2() {
        return loginPass2;
    }

    public void setLoginPass2(String loginPass2) {
        this.loginPass2 = loginPass2;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserWeiXin() {
        return userWeiXin;
    }

    public void setUserWeiXin(String userWeiXin) {
        this.userWeiXin = userWeiXin;
    }

    public String getInvitedCode() {
        return invitedCode;
    }

    public void setInvitedCode(String invitedCode) {
        this.invitedCode = invitedCode;
    }
}
