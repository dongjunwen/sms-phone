package com.bootdo.waimao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.waimao.dao.WmInvoiceOrderDao;
import com.bootdo.waimao.domain.WmInvoiceOrderDO;
import com.bootdo.waimao.service.WmInvoiceOrderService;



@Service
public class WmInvoiceOrderServiceImpl implements WmInvoiceOrderService {
	@Autowired
	private WmInvoiceOrderDao wmInvoiceOrderDao;
	
	@Override
	public WmInvoiceOrderDO get(Integer id){
		return wmInvoiceOrderDao.get(id);
	}
	
	@Override
	public List<WmInvoiceOrderDO> list(Map<String, Object> map){
		return wmInvoiceOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wmInvoiceOrderDao.count(map);
	}
	
	@Override
	public int save(WmInvoiceOrderDO wmInvoiceOrder){
		return wmInvoiceOrderDao.save(wmInvoiceOrder);
	}
	
	@Override
	public int update(WmInvoiceOrderDO wmInvoiceOrder){
		return wmInvoiceOrderDao.update(wmInvoiceOrder);
	}
	
	@Override
	public int remove(Integer id){
		return wmInvoiceOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wmInvoiceOrderDao.batchRemove(ids);
	}

	@Override
	public List<WmInvoiceOrderDO> selectByIds(Integer[] ids) {
		return wmInvoiceOrderDao.selectByIds(ids);
	}

}
