package com.bootdo.waimao.service;

import com.bootdo.waimao.domain.WmInvoiceOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 发票单据
 * 
 * @author luiz
 * @email 1992lcg@163.com
 * @date 2018-09-27 15:28:58
 */
public interface WmInvoiceOrderService {
	
	WmInvoiceOrderDO get(Integer id);
	
	List<WmInvoiceOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WmInvoiceOrderDO wmInvoiceOrder);
	
	int update(WmInvoiceOrderDO wmInvoiceOrder);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<WmInvoiceOrderDO> selectByIds(Integer[] ids);
}
