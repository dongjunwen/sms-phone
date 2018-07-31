package com.bootdo.system.service.impl;

import com.bootdo.system.enums.ExecStatus;
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
	public List<SmsDO> listAvailable() {
		return smsDao.listAvailable();
	}

	@Override
	public List<SmsDO> selectByOrderNo(String orderNo) {
		return smsDao.selectByOrderNo(orderNo);
	}

}
