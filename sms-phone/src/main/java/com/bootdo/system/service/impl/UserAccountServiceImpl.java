package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.UserAccountDao;
import com.bootdo.system.domain.UserAccountDO;
import com.bootdo.system.service.UserAccountService;



@Service
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Override
	public UserAccountDO get(Long id){
		return userAccountDao.get(id);
	}
	
	@Override
	public List<UserAccountDO> list(Map<String, Object> map){
		return userAccountDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userAccountDao.count(map);
	}
	
	@Override
	public int save(UserAccountDO userAccount){
		return userAccountDao.save(userAccount);
	}
	
	@Override
	public int update(UserAccountDO userAccount){
		return userAccountDao.update(userAccount);
	}
	
	@Override
	public int remove(Long id){
		return userAccountDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userAccountDao.batchRemove(ids);
	}

	@Override
	public UserAccountDO selectByUserId(Long userId) {
			return userAccountDao.selectByUserId(userId);
	}

}
