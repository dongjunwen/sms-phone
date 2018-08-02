package com.bootdo.system.dao;

import com.bootdo.system.domain.ProductDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 产品定价表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 09:55:43
 */
@Mapper
public interface ProductDao {

	ProductDO get(Long id);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	ProductDO findPrice(@Param("validDay") int validDay);
}
