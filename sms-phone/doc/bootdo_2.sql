/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - bootdo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bootdo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bootdo`;

/*Table structure for table `bom_config` */

DROP TABLE IF EXISTS `bom_config`;

CREATE TABLE `bom_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url_str` varchar(512) DEFAULT NULL COMMENT '请求地址',
  `param_value` varchar(512) DEFAULT NULL COMMENT '请求参数',
  `post_type` varchar(32) DEFAULT 'GET' COMMENT '请求类型 POSTJSON GET POST',
  `is_valid` char(1) DEFAULT '1' COMMENT '是否生效 1：生效 0：失效',
  `success_resp` varchar(512) DEFAULT NULL COMMENT '成功返回内容',
  PRIMARY KEY (`id`),
  KEY `index_no` (`url_str`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='请求路径配置';

/*Data for the table `bom_config` */

insert  into `bom_config`(`id`,`url_str`,`param_value`,`post_type`,`is_valid`,`success_resp`) values (1,'http://www.huobiotc365.com/api/code','{\"username\":\"手机号\",\"type\":\"1\"}','POSTJSON','1',NULL),(2,'http://m.h231.com/Home/User/sendMsg','typeid=1&phone=手机号','POST','1',NULL),(3,'https://reg.qun.hk/v2/captcha/send?phone=手机号&sign=3aeea8da75c84858ad6e9dc5729b01bd&product=qun',NULL,'GET','1',NULL),(4,'http://wk559.com/sendsm.asp','c=reg&uphone=手机号&code=','POST','1',NULL),(5,'https://www.biex.io/Register/getCode','mobile=手机号','POST','1',NULL),(6,'http://sws.smardata.cn/sendsms.php','mobile=手机号','POST','0',NULL),(7,'http://ipfs.thbqpc.cn/index/publics/send.html','mobile=手机号','POST','1',NULL),(8,'http://www.huanxingyouwo.com/wxweb/v1/app/sms/sendsms.do?phone=手机号',NULL,'GET','0',NULL),(9,'https://www.nkfe64.com/api/?d=user&c=call&m=sendcode','mobile=手机号','POST','0',NULL),(10,'http://app.bttt8.cn/app!generateValidCodeAjax.action?vtype=Register&loginName=手机号&callbackparam=jsonpCallback&_=153067825392613',NULL,'GET','0',NULL),(11,'http://btl.988h5.cn/index.php/index/sem/send_edit_code/mobile/手机号',NULL,'GET','0','{\"status\":1,\"msg\":\"\\u9a8c\\u8bc1\\u7801\\u5df2\\u53d1\\u9001\\uff0c\\u8bf7\\u6ce8\\u610f\\u67e5\\u6536\"}'),(12,'http://tt.tkdlw.com:19123/regpost.php?action=get_sms&phone=手机号',NULL,'GET','0',NULL),(13,'https://api.58coin.com/user/security/sms_code/send','purpose=21&nation=211&mobile=手机号&ticket=&channel=116','POST','1','{\"code\":0,\"message\":\"操作成功\",\"data\":{\"ticket\":\"2ba98977-2f58-4a03-a570-6c8ca6a83cfc\"}}'),(14,'http://www.11bbu.com/pc/index/sjyzm?mobile=手机号',NULL,'GET','0',NULL),(15,'http://byser.jjy.com:8081/pcOoSendCode','phone=手机号','POST','0','超时'),(16,'https://8.58wwcp.com/m/phone_sendCode.do','phone=手机号','POST','0','有COOKIE'),(17,'http://olddriver.com/api/user/verify/v1?ran=0.9209865952038611&phone=手机号',NULL,'GET','0','有验证码'),(18,'http://huzhi.somesecret.com/index.php/wap/Login/sendSmsRegisterCode','mobile=手机号','GET','1','200就行'),(19,'http://wx.helpin.cn/wd-api/index.php?a=get_check_code&m=adduser','phone=手机号&simpleCaptcha=验证码','GET','0','有验证码'),(20,'http://www.cxmcoin.com/panda-api/sms/sendMobileSms','mobile=手机号&type=1','GET','1',NULL),(21,'https://yeyx.ink520.com/sendCode.php?phone=手机号',NULL,'GET','1','提示成功未收到短信'),(22,'http://my.i.hub.toocle.com/index.php?_w=false&_a=register&f=get_captcha_mobile&rand=0.2020970082762027&mobile=手机号&role=company25',NULL,'GET','0','有验证码'),(23,'http://www.duoduomimi.cn/simple/_sendMobileCode?captcha=&mobile=手机号',NULL,'GET','0','业务停机'),(24,'http://859500.net/sms/demo/sendSms.php?mhm=手机号&myzm=54958827',NULL,'GET','0','有验证码'),(25,'http://www.zhongll.cn/app/sendsms?mobile=手机号&type=028',NULL,'GET','0',NULL),(26,'https://m.mycchk.com/tools/submit_ajax.ashx?action=user_regverify_smscode&site=mobile&mobile=手机号&areacode=8629',NULL,'GET','1','{\"status\":1, \"time\":\"3\", \"msg\":\"手机验证码发送成功！\"}'),(27,'http://www.test.11xiuge.com/api/get_mobile_code','mobile=手机号&type=01','POST','1','{\"msg\":\"success\",\"code\":0,\"registed\":false}'),(28,'http://www.szs163.com/Login/sendCode.html','mobile=手机号','POST','0','{\"status\":0,\"message\":\"\\u77ed\\u4fe1\\u53d1\\u9001\\u5931\\u8d25\"}'),(29,'http://api.shblock.net/dice/Captcha/SendCaptcha?phone_number=手机号&type=132',NULL,'GET','0','超时'),(30,'https://m.soonyo.net/register/send','is_ajax=1&mobile=手机号&verify=33','POST','1',NULL),(31,'https://mall.hmzixin.com/simple/_sendMobileCode','frtag=&mobile=手机号','POST','0','有验证码'),(32,'https://api.yaofache.com/web/user/SendVerifyCode','{\"phone\": \"手机号\", \"Function\": \"1\"}','POSTJSON','1','{\"Code\":200,\"Message\":\"\",\"Data\":\"\",\"IsSuccess\":true}'),(33,'http://www.bluexiang.cn/home/users/getphoneverifycode.html','userPhone=手机号','POST','1',NULL),(34,'https://www.biex.io/Register/getCode','mobile=手机号','POST','0','301重定向'),(35,'http://sws.smardata.cn/sendsms.php?mobile=手机号','','POST','0','没反应'),(36,'https://www.guanzhu.mobi/user/getRegisterPhoneVerifyCode?resultType=json&phone=手机号',NULL,'GET','0','有验证码'),(37,'https://www.huancaicp.com/user/RegisterSendMobileCodeNew?r=0.7687931335786007','mobile=手机号','POST','0','超时'),(38,'http://www.huanxingyouwo.com/adv/v1/app/sms/sendsms.do?phone=手机号','','GET','0',NULL),(39,'http://www.17yiqilai.com/index.php/home/ajax/smscode.html','phone=手机号','POST','0','超时'),(40,'https://account-httpd.61.com/index.php','cmd=1303&phone=手机号&userid=0','POST','1','{\"result\":0}'),(41,'http://app.bttt8.cn/app!generateValidCodeAjax.action?vtype=Register&loginName=手机号&callbackparam=jsonpCallback&_=1530678253926',NULL,'GET','1',NULL),(42,'http://btl.988h5.cn/index.php/index/sem/send_edit_code/mobile/手机号',NULL,'GET','1',NULL),(43,'http://tt.tkdlw.com:19123/regpost.php?action=get_sms&phone=手机号',NULL,'GET','0',NULL),(44,'https://activity.vipkid.com.cn/rest/activity/api/activity/verifycode/sms','mobile=手机号&imageCode=&key=&source=SIGNUP','POST','1',NULL),(45,'https://wallet.silkchain.io/Account/CheckUserParams','Option=SendPhoneCode&AreaCode=%2B86&UserParmas=手机号','POST','1',NULL),(46,'http://www.jrcp16.com/sms_sendCode','mobile=手机号','POST','0',NULL),(47,'http://www.zhekou5.com/user/checkusername999.asp?vcode=2222&mobi=手机号&step=getverifycode&r=0.08863844263239462',NULL,'GET','0',NULL),(48,'https://api-v5-0.yangcong345.com/captchas','phone=手机号','POST','1',NULL),(49,'https://www.90qh.com/class/server.php?c=ue.user&t=1531308152275','api=signinTelkey&usertel=手机号','POST','1',NULL),(50,'http://vip.kxyxyt.com/index.php?s=/home/user/sendregmsg.html','mobile=手机号','POST','1',NULL),(51,'http://www.maidamaida.com/auth/send?mobile=手机号',NULL,'GET','0','有验证码'),(52,'https://sso.kuaidi100.com/sso/mobileapi.do?method=sendcode','name=手机号','POST','1',NULL),(53,'http://tttsys.cn/common/send/captcha','phone=手机号&type=1','POST','0','发送失败'),(54,'https://wx.gouwan188.com/FrontLogin/sendVerifyCode','mobile=手机号','POST','0',NULL),(55,'http://www.datealive.com/ajaxPhoneVercode','phone=手机号','POST','1',NULL),(56,'https://www.shbapi.com/api/smscode/getSmsCode','mobile=手机号&authType=REGISTER','POST','1',NULL),(57,'https://www.chelun.com/getCaptcha.html?phone=手机号',NULL,'GET','0','有验证码'),(58,'https://www.meadjohnson.com.cn/send/auth-code/register/手机号',NULL,'GET','1',NULL),(59,'https://xueqiu.com/account/sms/send_verification_code.json','areacode=86&telephone=手机号','POST','0','有COOKIE'),(60,'http://www.renqizhu.cn/Base/sendSms','mobile_phone=手机号&status=1','POST','1',NULL),(61,'https://mzone.yqb.com/mzone-http/captcha/js/query','phone=手机号','POST','0','网页打不开'),(62,'https://www.gofobao.com/api/pub/pc/v2/sms/register','phone=手机号','POST','1',NULL),(63,'http://www.ims-ptne.cn/webhall/register/sendCode','mobile=手机号','POST','1',NULL),(64,'http://www.bxcp.com/register/mobile_send','phone=手机号&send=send\r\n','POST','0','异常'),(65,'http://www.36588.com.cn/getCodeAgain.do','mobile=手机号','POST','1',NULL),(66,'https://www.chediandian.com/home/get-code','userMobile=手机号','POST','1',NULL),(67,'http://www.iluoyang.com/member.php?mod=register&send=m','mob=手机号','POST','1',NULL),(68,'https://www.kujiale.com/api/sendsms?tel=手机号&type=6&usecall=true',NULL,'GET','0','有COOKIE');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;