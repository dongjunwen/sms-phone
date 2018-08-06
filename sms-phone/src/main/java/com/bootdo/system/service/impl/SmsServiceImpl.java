package com.bootdo.system.service.impl;

import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.system.dao.OrderDao;
import com.bootdo.system.dao.UserDao;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.enums.ExecStatus;
import com.bootdo.system.vo.CustResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.SmsDao;
import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.service.SmsService;



@Service
public class SmsServiceImpl implements SmsService {
	@Autowired
	private SmsDao smsDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public SmsDO get(Long id){
		return smsDao.get(id);
	}
	
	@Override
	public List<SmsDO> list(Map<String, Object> map){
		return smsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return smsDao.count(map);
	}
	
	@Override
	public int save(SmsDO sms){
		return smsDao.save(sms);
	}
	
	@Override
	public int update(SmsDO sms){
		return smsDao.update(sms);
	}
	
	@Override
	public int remove(Long id){
		return smsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return smsDao.batchRemove(ids);
	}



	@Override
	public void addPhone(SmsDO smsDO) {
		int countNum=smsDao.countByIndex(smsDO);
		if(countNum<=0){
			smsDO.setExecStatus(ExecStatus.PROCESS.getCode());
			smsDO.setCreateTime(new Date());
			smsDao.save(smsDO);
		}
	}

	@Override
	public int countByOrderNo(SmsDO smsDO) {
		return smsDao.countByOrderNo(smsDO);
	}

	@Override
	public List<SmsDO> listAvailable() {
		return smsDao.listAvailable();
	}

	@Override
	public List<SmsDO> selectByOrderNo(String orderNo) {
		return smsDao.selectByOrderNo(orderNo);
	}

	@Override
	public CustResultVo findByUser(Long userId) {
		CustResultVo custResultVo=new CustResultVo();
		String custBoardMsg=dictService.getName("CUST_BOARD_MSG","CUST_BOARD_MSG");
		custResultVo.setCustBoardMsg(custBoardMsg);
		List<OrderDO> orderDOS=orderDao.selectByUserId(userId);
		if(orderDOS!=null && orderDOS.size()>=1){
			OrderDO orderDO=orderDOS.get(0);
			List<SmsDO> smsDOS=selectByOrderNo(orderDO.getOrderNo());
			custResultVo.setIfShow(true);
			custResultVo.setSellerQq(orderDO.getOwnerUserQq());
			custResultVo.setSellerWeiXin(orderDO.getOwnerUserWeiXin());
			long remainTime=orderDO.getUnvalidTime().getTime()-orderDO.getUseTime().getTime();
			long remainDay=(remainTime / (1000 * 60 * 60 * 24));
			custResultVo.setOrderNo(orderDO.getOrderNo());
			custResultVo.setRemainDay(remainDay);
			custResultVo.setUseTime(DateUtils.format(orderDO.getUseTime(),"yyyy-MM-dd HH:mm:ss"));
			custResultVo.setUnvalidTime(DateUtils.format(orderDO.getUnvalidTime(),"yyyy-MM-dd HH:mm:ss"));
			custResultVo.setSmsDOS(smsDOS);
		}else{
			custResultVo.setIfShow(false);
			UserDO userDO=userDao.getPUser(userId);
			custResultVo.setSellerQq(userDO.getQQ());
			custResultVo.setSellerWeiXin(userDO.getWeiXin());
		}
		return custResultVo;
	}

}
