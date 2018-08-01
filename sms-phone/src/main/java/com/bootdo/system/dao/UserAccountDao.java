package com.bootdo.system.dao;

import com.bootdo.system.domain.UserAccountDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:50
 */
@Mapper
public interface UserAccountDao {

	UserAccountDO get(Long id);
	
	List<UserAccountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserAccountDO userAccount);
	
	int update(UserAccountDO userAccount);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    UserAccountDO selectByUserId(Long userId);
}
