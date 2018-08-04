package com.bootdo.system.service;

import com.bootdo.system.domain.ProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品定价表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-04 17:11:06
 */
public interface ProductService {
	
	ProductDO get(Long id);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	ProductDO findPrice(String invalidType, Integer invalidDays);

	ProductDO findByNo(String productNo);
}
