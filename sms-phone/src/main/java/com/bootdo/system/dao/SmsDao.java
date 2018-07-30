package com.bootdo.system.dao;

import com.bootdo.system.domain.SmsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 短信轰炸
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-30 19:34:12
 */
@Mapper
public interface SmsDao {

	SmsDO get(Long id);
	
	List<SmsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SmsDO sms);
	
	int update(SmsDO sms);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
