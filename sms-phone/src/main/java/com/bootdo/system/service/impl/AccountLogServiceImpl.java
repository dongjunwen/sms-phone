package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.AccountLogDao;
import com.bootdo.system.domain.AccountLogDO;
import com.bootdo.system.service.AccountLogService;



@Service
public class AccountLogServiceImpl implements AccountLogService {
	@Autowired
	private AccountLogDao accountLogDao;
	
	@Override
	public AccountLogDO get(Long id){
		return accountLogDao.get(id);
	}
	
	@Override
	public List<AccountLogDO> list(Map<String, Object> map){
		return accountLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return accountLogDao.count(map);
	}
	
	@Override
	public int save(AccountLogDO accountLog){
		return accountLogDao.save(accountLog);
	}
	
	@Override
	public int update(AccountLogDO accountLog){
		return accountLogDao.update(accountLog);
	}
	
	@Override
	public int remove(Long id){
		return accountLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return accountLogDao.batchRemove(ids);
	}
	
}
