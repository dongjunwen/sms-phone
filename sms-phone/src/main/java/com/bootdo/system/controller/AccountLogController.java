package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.AccountLogDO;
import com.bootdo.system.service.AccountLogService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 账户交易记录
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:43
 */
 
@Controller
@RequestMapping("/system/accountLog")
public class AccountLogController {
	@Autowired
	private AccountLogService accountLogService;
	
	@GetMapping()
	@RequiresPermissions("system:accountLog:accountLog")
	String AccountLog(){
	    return "system/accountLog/accountLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:accountLog:accountLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AccountLogDO> accountLogList = accountLogService.list(query);
		int total = accountLogService.count(query);
		PageUtils pageUtils = new PageUtils(accountLogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:accountLog:add")
	String add(){
	    return "system/accountLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:accountLog:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AccountLogDO accountLog = accountLogService.get(id);
		model.addAttribute("accountLog", accountLog);
	    return "system/accountLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:accountLog:add")
	public R save( AccountLogDO accountLog){
		if(accountLogService.save(accountLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:accountLog:edit")
	public R update( AccountLogDO accountLog){
		accountLogService.update(accountLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:accountLog:remove")
	public R remove( Long id){
		if(accountLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:accountLog:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		accountLogService.batchRemove(ids);
		return R.ok();
	}
	
}
