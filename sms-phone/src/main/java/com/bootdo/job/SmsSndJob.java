package com.bootdo.job;

import com.bootdo.system.domain.ConfigDO;
import com.bootdo.system.domain.SmsBean;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.ConfigService;
import com.bootdo.system.service.SmsService;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:luiz
 * @Date: 2018/7/30 11:13
 * @Descripton:
 * @Modify :
 **/
@Component
public class SmsSndJob {

    @Resource
    SmsService smsService;
    @Autowired
    ConfigService configService;

    private static final  Disruptor<SmsBean> dataDisruptor ;

    static {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //创建数据工厂
        DataFactory dataFactory = new DataFactory();
        //设置缓冲区大小，必须为2的指数，否则会有异常
        int buffersize = 1024;
        dataDisruptor = new Disruptor<SmsBean>(dataFactory, buffersize,
                service);
        //创建消费者线程
        dataDisruptor.handleEventsWithWorkerPool(
                new SmsConsumer()
        );
        //启动
        dataDisruptor.start();
    }
    //每隔70秒执行
    //@Scheduled(fixedRate = 70000)
    public void scdJob(){
        //获取其队列
        RingBuffer<SmsBean> ringBuffer = dataDisruptor.getRingBuffer();
        //创建生产者
        SmsProduce smsProduce=new SmsProduce(ringBuffer);
        List<ConfigDO> configDOList=configService.listAvailable();
        List<SmsDO> smsDOList= smsService.listAvailable();
        for(SmsDO smsDO: smsDOList){
            SmsBean smsBean=new SmsBean();
            smsBean.setOrderNo(smsDO.getOrderNo());
            smsBean.setPhoneNum(smsDO.getPhoneNum());
            smsBean.setConfigDOList(configDOList);
            smsProduce.pushData(smsBean);

            smsDO.setSuccessNum(1);
            smsService.addNum(smsDO);
        }
    }


}
