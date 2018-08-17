package com.bootdo.job;

import com.bootdo.system.domain.SmsBean;
import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @Author:luiz
 * @Date: 2018/7/31 15:20
 * @Descripton:短信生产者
 * @Modify :
 **/
public class SmsProduce {
    private static final Logger logger= LoggerFactory.getLogger(SmsProduce.class);
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
            logger.info("生产者制造数据...");
            dataRingBuffer.publish(next);
        }
    }


}
