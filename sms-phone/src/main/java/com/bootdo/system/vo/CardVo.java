package com.bootdo.system.vo;

import com.bootdo.system.enums.InvalidDayType;

/**
 * @Author:luiz
 * @Date: 2018/7/31 10:48
 * @Descripton:
 * @Modify :
 **/
public class CardVo {
    private InvalidDayType invalidDayType;
    private int invalidDays;
    private int cardNum;

    public InvalidDayType getInvalidDayType() {
        return invalidDayType;
    }

    public void setInvalidDayType(InvalidDayType invalidDayType) {
        this.invalidDayType = invalidDayType;
    }

    public int getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(int invalidDays) {
        this.invalidDays = invalidDays;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
}
