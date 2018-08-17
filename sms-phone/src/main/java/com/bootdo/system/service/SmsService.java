package com.bootdo.system.service;

import com.bootdo.system.domain.SmsDO;
import com.bootdo.system.vo.CustResultVo;

import java.util.List;
import java.util.Map;

/**
 * 短信轰炸
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-30 19:34:12
 */
public interface SmsService {
	
	SmsDO get(Long id);
	
	List<SmsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SmsDO sms);
	
	int update(SmsDO sms);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    void addPhone(SmsDO smsDO);

	int countByOrderNo (SmsDO smsDO);

	List<SmsDO> listAvailable();

    List<SmsDO> selectByOrderNo(String orderNo);

    CustResultVo findByUser(Long userId);

	int addNum(SmsDO smsDO);
}
