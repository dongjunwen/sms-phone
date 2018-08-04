package com.bootdo.system.service.impl;

import com.bootdo.system.enums.InvalidDayType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ProductDao;
import com.bootdo.system.domain.ProductDO;
import com.bootdo.system.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	private static  final Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductDO get(Long id){
		return productDao.get(id);
	}
	
	@Override
	public List<ProductDO> list(Map<String, Object> map){
		return productDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDao.count(map);
	}
	
	@Override
	public int save(ProductDO product){
		return productDao.save(product);
	}
	
	@Override
	public int update(ProductDO product){
		return productDao.update(product);
	}
	
	@Override
	public int remove(Long id){
		return productDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return productDao.batchRemove(ids);
	}

	@Override
	public ProductDO findPrice(String invalidType, Integer invalidDays) {
		int validDay=0;
		if(InvalidDayType.MIN.getCode().equals(invalidType)){
			validDay = invalidDays/24*60;
		}else  if(InvalidDayType.HOU.getCode().equals(invalidType)){
			validDay = invalidDays/24;
		}else  if(InvalidDayType.DAY.getCode().equals(invalidType)){
			validDay = invalidDays;
		}else  if(InvalidDayType.MON.getCode().equals(invalidType)){
			validDay = invalidDays*30;
		}else  if(InvalidDayType.YEA.getCode().equals(invalidType)){
			validDay = invalidDays*30*12;
		}
		logger.info("[时间区间]validDay={}",validDay);
		return productDao.findPrice(validDay);

	}

	@Override
	public ProductDO findByNo(String productNo) {
		return productDao.findByProductNo(productNo);
	}

}
