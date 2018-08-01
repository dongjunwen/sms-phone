package com.bootdo.system.service;

import com.bootdo.system.domain.AccountLogDO;

import java.util.List;
import java.util.Map;

/**
 * 账户交易记录
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:43
 */
public interface AccountLogService {
	
	AccountLogDO get(Long id);
	
	List<AccountLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AccountLogDO accountLog);
	
	int update(AccountLogDO accountLog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
