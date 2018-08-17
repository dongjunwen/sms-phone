package com.bootdo.job;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.system.domain.ConfigDO;
import com.bootdo.system.domain.SmsBean;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.SmsService;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:luiz
 * @Date: 2018/7/31 15:20
 * @Descripton:
 * @Modify :
 **/
@Component
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
        try{
            doSend(smsBean);
        }catch (Exception e){
            logger.error("处理短信失败:{}",e);
        }
    }
   /* public void run1(){
        try {
            Thread.sleep(1000);
            logger.info("模拟线程等待一秒...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public void doSend(SmsBean smsBean){
        List<ConfigDO> configDOList=smsBean.getConfigDOList();
        if(configDOList==null) return;
        for (ConfigDO configDO:smsBean.getConfigDOList()){
            StepMsg stepMsg=step1(configDO);
            step2(stepMsg,configDO,smsBean);
        }
    }

    private StepMsg step1(ConfigDO configDO){
        StepMsg stepMsg=new StepMsg();
        String step1Url=configDO.getStep1Url();
        String step1Type=configDO.getStep1Type();
        String step1ContainKey=configDO.getStep1ContainKey();
        String step1HtmlCode=configDO.getStep1HtmlCode();
        if(StringUtils.isNotEmpty(step1Url)){
            stepMsg.setUseStep1(true);
            HttpResponse httpResponse=HttpClientUtil.doGetResp(step1Url);
             if("Cookie".equals(step1Type)){
                String cookieStr= getCookieStr(httpResponse,step1ContainKey.split(";"));
                stepMsg.setCookieStr(cookieStr);
            }
            String hiddenStr="";
            if("VerifyCode".equals(step1Type)){
                hiddenStr= getVerifyCode(httpResponse,step1ContainKey);
            }
            if(StringUtils.isNotEmpty(step1HtmlCode)){
                hiddenStr=hiddenStr+getReqParam(httpResponse,step1HtmlCode.split(";"));
            }
            stepMsg.setParamStr(hiddenStr);
        }
        return stepMsg;
    }


    private String getVerifyCode( HttpResponse httpResponse,String hiddenField){
        HttpEntity entity = httpResponse.getEntity();
        InputStream instream = null;
        try {
            instream = entity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer stb=new StringBuffer("");
        stb.append(getValueByNameFromJpg(instream,hiddenField)).append("&");
        return stb.toString();
    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    private static String getValueByNameFromJpg(InputStream instream ,String hiddenField){
        try{
            if(instream==null) return "";
            File retFile=new File("/home/tessreact/tmp.jpg");
            FileUtils.writeByteArrayToFile(retFile,input2byte(instream));
            Tesseract tessreact = new Tesseract();
            tessreact.setDatapath("/home/tessreact");
            String verifyCode=  tessreact.doOCR(retFile);
            System.err.println("getValueByNameFromJpg:"+verifyCode);
            return hiddenField+"="+verifyCode;
        }catch (Exception e){
            logger.error("获取验证码失败:{}",e);
        }
        return "";
    }

    private String getReqParam(HttpResponse httpResponse,String[] hiddenArray){
        HttpEntity entity = httpResponse.getEntity();
        String returnHtml="";
        if (entity != null) {
            try {
            InputStream instream = entity.getContent();
                returnHtml = IOUtils.toString(instream, "UTF-8");
            } catch (Exception e) {
                logger.error("存储失败:{}",e);
            }
        }
        StringBuffer stb=new StringBuffer("");
        for(int i=0;i<=hiddenArray.length-1;i++){
            stb.append(getValueByNameFromHtml(returnHtml,hiddenArray[i])).append("&");
        }
        String resultStr=stb.toString();
        if(StringUtils.isNotEmpty(resultStr)){
            resultStr = resultStr.substring(0,resultStr.length()-1);
        }
        return resultStr;
    }

    private String getValueByNameFromHtml(String returnHtml,String hiddenName){
        try{
            if(StringUtils.isEmpty(returnHtml)) return "";
            File retFile=new File("/home/tmp.html");
            FileUtils.writeStringToFile(retFile,returnHtml,"UTF-8");
            HtmlCleaner cleaner = new HtmlCleaner();
            TagNode node = cleaner.clean(retFile,  "GBK");
            Object[] ns = node.getElementsByAttValue("name" ,  hiddenName ,  true ,  true );
            String tokenStr="";
            if(ns!=null&&ns.length>=1){
                TagNode tagNode = (TagNode) ns[0];
                tokenStr=tagNode.getAttributeByName("value").toString();
            }
            return hiddenName+"="+tokenStr;
        }catch (Exception e){
            logger.error("获取Html失败:{}",e);
        }
        return "";
    }

    private String getCookieStr( HttpResponse httpResponse,String[] containKeyArray){
        Header[] cookieHeader=httpResponse.getHeaders("Set-Cookie");
        String cookieStr="";
        for(int i=0;i<=cookieHeader.length-1;i++){
            String headValue=cookieHeader[i].getValue();
            String[] headValueArr=headValue.split(";");
            for(int j=0;j<=headValueArr.length-1;j++){
                String cookiStr=headValueArr[j];
                for(int k=0;k<=containKeyArray.length-1;k++){
                    if(cookiStr.contains(containKeyArray[k])){
                        cookieStr=cookieStr+cookiStr+";";
                    }
                }

            }
        }
        return cookieStr;
    }

    private void step2(StepMsg stepMsg,ConfigDO configDO,SmsBean smsBean){
        String phoneNum=smsBean.getPhoneNum();
        String postType= configDO.getPostType();
        String postUrl= configDO.getUrlStr();
        String postParam= configDO.getParamValue();
        if(stepMsg.isUseStep1()){
            if(StringUtils.isNotEmpty(stepMsg.getParamStr()))
             postParam=postParam+"&"+stepMsg.getParamStr();
           // if(StringUtils.isNotEmpty(stepMsg.getCookieStr())){
                if("POSTJSON".equals(postType)){
                    postParam=postParam.replace("手机号",phoneNum);
                    String respData=HttpClientUtil.doPostJSon(postUrl,postParam,stepMsg.getCookieStr());
                    logger.info("[消费者]"+postUrl+"短信呼叫返回POSTJSON COOKIE:"+respData);
                }else if("POST".equals(postType)){
                    postParam=postParam.replace("手机号",phoneNum);
                    String respData=HttpClientUtil.doPostStr(postUrl,postParam,stepMsg.getCookieStr());
                    logger.info("[消费者]"+postUrl+"短信呼叫返回POST COOKIE:"+respData);
                }
           // }
        }else{
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
