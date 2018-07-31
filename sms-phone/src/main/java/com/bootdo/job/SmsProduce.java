package com.bootdo.job;

import com.bootdo.system.domain.SmsBean;
import com.bootdo.system.domain.SmsDO;
import com.lmax.disruptor.RingBuffer;


/**
 * @Author:luiz
 * @Date: 2018/7/31 15:20
 * @Descripton:短信生产者
 * @Modify :
 **/
public class SmsProduce {

    //队列
    private final RingBuffer<SmsBean> dataRingBuffer;

    public SmsProduce(RingBuffer<SmsBean> dataRingBuffer) {
        this.dataRingBuffer = dataRingBuffer;
    }

    /**
     * 插入数据
     * @param
     */
    public void pushData(SmsBean smsBean) {

        //获取下一个可用位置
        long next = dataRingBuffer.next();
        try {
            //获取容器
            SmsBean data = dataRingBuffer.get(next);
            //设置数据
            data.setOrderNo(smsBean.getOrderNo());
            data.setPhoneNum(smsBean.getPhoneNum());
            data.setConfigDOList(smsBean.getConfigDOList());
        } finally {
            //插入
            dataRingBuffer.publish(next);
        }
    }


}
