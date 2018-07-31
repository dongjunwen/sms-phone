package com.bootdo.job;

import com.bootdo.system.domain.ConfigDO;
import com.bootdo.system.domain.SmsBean;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.ConfigService;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:luiz
 * @Date: 2018/7/31 15:20
 * @Descripton:
 * @Modify :
 **/
public class SmsConsumer implements WorkHandler<SmsBean>,EventHandler<SmsBean> {
    private static final Logger logger= LoggerFactory.getLogger(SmsConsumer.class);
    @Override
    public void onEvent(SmsBean smsBean, long l, boolean b) throws Exception {
        logger.info("[消费者]线程名称:{},第{}个",Thread.currentThread().getName(),l);
        this.onEvent(smsBean);
    }

    @Override
    public void onEvent(SmsBean smsBean) throws Exception {
        logger.info("[消费者]线程名称:{},卡密:{},手机号:{}开始处理...",Thread.currentThread().getName(),smsBean.getOrderNo(),smsBean.getPhoneNum());
        run(smsBean);
    }
    public void run(SmsBean smsBean){
        List<ConfigDO> configDOList=smsBean.getConfigDOList();
        if(configDOList==null) return;
        for (ConfigDO configDO:smsBean.getConfigDOList()){
            String phoneNum=smsBean.getPhoneNum();
            String postType= configDO.getPostType();
            String postUrl= configDO.getUrlStr();
            String postParam= configDO.getParamValue();
            if("POSTJSON".equals(postType)){
                postParam=postParam.replace("手机号",phoneNum);
                String respData=HttpClientUtil.doPostJSon(postUrl,postParam);
                logger.info("[消费者]"+postUrl+"短信呼叫返回POSTJSON:"+respData);
            }else if("POST".equals(postType)){
                postParam=postParam.replace("手机号",phoneNum);
                String respData=HttpClientUtil.doPostStr(postUrl,postParam);
                logger.info("[消费者]"+postUrl+"短信呼叫返回POST:"+respData);
            }else{
                postUrl=postUrl.replace("手机号",phoneNum);
                String respData=HttpClientUtil.doGet(postUrl);
                logger.info("[消费者]"+postUrl+"短信呼叫返回:"+respData);
            }
        }
    }


}
