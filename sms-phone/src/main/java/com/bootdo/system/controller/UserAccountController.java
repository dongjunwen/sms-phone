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

import com.bootdo.system.domain.UserAccountDO;
import com.bootdo.system.service.UserAccountService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:50
 */
 
@Controller
@RequestMapping("/system/userAccount")
public class UserAccountController {
	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping()
	@RequiresPermissions("system:userAccount:userAccount")
	String UserAccount(){
	    return "system/userAccount/userAccount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:userAccount:userAccount")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserAccountDO> userAccountList = userAccountService.list(query);
		int total = userAccountService.count(query);
		PageUtils pageUtils = new PageUtils(userAccountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:userAccount:add")
	String add(){
	    return "system/userAccount/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:userAccount:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UserAccountDO userAccount = userAccountService.get(id);
		model.addAttribute("userAccount", userAccount);
	    return "system/userAccount/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:userAccount:add")
	public R save( UserAccountDO userAccount){
		if(userAccountService.save(userAccount)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:userAccount:edit")
	public R update( UserAccountDO userAccount){
		userAccountService.update(userAccount);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:userAccount:remove")
	public R remove( Long id){
		if(userAccountService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:userAccount:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userAccountService.batchRemove(ids);
		return R.ok();
	}
	
}
