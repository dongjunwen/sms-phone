package com.bootdo.job;

import com.bootdo.system.domain.SmsBean;
import com.bootdo.system.domain.SmsDO;
import com.lmax.disruptor.EventFactory;

/**
 * @Author:luiz
 * @Date: 2018/7/31 15:26
 * @Descripton:
 * @Modify :
 **/
public class DataFactory implements EventFactory<SmsBean> {

    @Override
    public SmsBean newInstance() {
        return new SmsBean();
    }
}
