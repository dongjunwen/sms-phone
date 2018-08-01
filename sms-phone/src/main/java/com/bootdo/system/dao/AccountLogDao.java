package com.bootdo.system.dao;

import com.bootdo.system.domain.AccountLogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 账户交易记录
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:43
 */
@Mapper
public interface AccountLogDao {

	AccountLogDO get(Long id);
	
	List<AccountLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AccountLogDO accountLog);
	
	int update(AccountLogDO accountLog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
