package com.bootdo.waimao.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.waimao.domain.WmInvoiceOrderDO;
import com.bootdo.waimao.service.WmInvoiceOrderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletResponse;

/**
 * 发票单据
 * 
 * @author luiz
 * @email 1992lcg@163.com
 * @date 2018-09-27 15:28:58
 */
 
@Controller
@RequestMapping("/waimao/wmInvoiceOrder")
public class WmInvoiceOrderController {
	@Autowired
	private WmInvoiceOrderService wmInvoiceOrderService;
	
	@GetMapping()
	@RequiresPermissions("waimao:wmInvoiceOrder:wmInvoiceOrder")
	String WmInvoiceOrder(){
	    return "waimao/wmInvoiceOrder/wmInvoiceOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("waimao:wmInvoiceOrder:wmInvoiceOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WmInvoiceOrderDO> wmInvoiceOrderList = wmInvoiceOrderService.list(query);
		int total = wmInvoiceOrderService.count(query);
		PageUtils pageUtils = new PageUtils(wmInvoiceOrderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("waimao:wmInvoiceOrder:add")
	String add(){
	    return "waimao/wmInvoiceOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("waimao:wmInvoiceOrder:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WmInvoiceOrderDO wmInvoiceOrder = wmInvoiceOrderService.get(id);
		model.addAttribute("wmInvoiceOrder", wmInvoiceOrder);
	    return "waimao/wmInvoiceOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("waimao:wmInvoiceOrder:add")
	public R save( WmInvoiceOrderDO wmInvoiceOrder){
		if(wmInvoiceOrderService.save(wmInvoiceOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("waimao:wmInvoiceOrder:edit")
	public R update( WmInvoiceOrderDO wmInvoiceOrder){
		wmInvoiceOrderService.update(wmInvoiceOrder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("waimao:wmInvoiceOrder:remove")
	public R remove( Integer id){
		if(wmInvoiceOrderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("waimao:wmInvoiceOrder:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wmInvoiceOrderService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 导出
	 */
	@RequestMapping( "/batchExport")
	@RequiresPermissions("waimao:wmInvoiceOrder:batchExport")
	public void batchExport(@RequestParam("ids") Integer[] ids, HttpServletResponse response){
		Map dataMap=new HashMap();
		List<WmInvoiceOrderDO> wmInvoiceOrderDOS=wmInvoiceOrderService.selectByIds(ids);
		dataMap.put("orderList",wmInvoiceOrderDOS);
		Resource invoiceExportResource=new FileSystemResource("/opt/java/config/waimao/invoiceOrderTemplate.xls");
		//将数据渲染到excel模板上
		Workbook workbook = null;
		try {
			workbook = new XLSTransformer().transformXLS(invoiceExportResource.getInputStream(), dataMap);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			workbook.write(output);
			String filename = "单证样例.xls";
			response.setContentType(String.format("%s;charset=utf-8", "application/x"));
			response.setHeader("Content-Disposition", "attachment;filename=" +            new String(filename.getBytes("utf-8"), "iso8859-1"));
			response.setHeader("Content-Length", String.valueOf(output.toByteArray().length));
			response.getOutputStream().write(output.toByteArray());
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
}
