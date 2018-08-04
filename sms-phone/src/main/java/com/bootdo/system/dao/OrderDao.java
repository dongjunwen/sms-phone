package com.bootdo.system.dao;

import com.bootdo.system.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 卡密相关
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-31 10:30:38
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    OrderDO selectByOrderNo(String orderNo);

    void batchDisable(Integer[] ids);

	void batchEnable(Integer[] ids);

    List<OrderDO> selectByUserId(Long userId);
}
