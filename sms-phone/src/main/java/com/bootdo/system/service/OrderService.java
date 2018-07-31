package com.bootdo.system.service;

import com.bootdo.system.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 卡密相关
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-31 10:30:38
 */
public interface OrderService {
	
	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	OrderDO selectByOrderNo(String orderNo);
}
