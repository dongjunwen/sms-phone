package com.bootdo.system.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.*;
import com.bootdo.system.domain.*;
import com.bootdo.system.enums.RoleCodeEnum;
import com.bootdo.system.service.AccountLogService;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserAccountService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.UserRechargeVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/proxy/user")
@Controller
public class ProxyUserController extends BaseController {
	private String prefix= "proxy/user";
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	AccountLogService accountLogService;
	@Autowired
	UserAccountService userAccountService;
	@RequiresPermissions("proxy:user:user")
	@GetMapping("")
	String user(Model model) {
		model.addAttribute("roles", listRoles());
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		params.put("puserId", ShiroUtils.getUserId());
		Query query = new Query(params);
		List<UserDO> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("proxy:user:add")
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		model.addAttribute("roles", listRoles());
		return prefix + "/add";
	}

	private List<RoleDO> listRoles() {
		List<RoleDO> roles = roleService.list();
		int i=0;
		for(RoleDO roleDo:roles){
			if(RoleCodeEnum.ADMIN.getCode().equals(roleDo.getRoleCode())){
				roles.remove(i);
				break;
			}
			i++;
		}
		return roles;
	}

	@RequiresPermissions("proxy:user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		UserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
		List<RoleDO> roles = roleService.listNew(id);
		model.addAttribute("roles", roles);
		return prefix+"/edit";
	}

	@RequiresPermissions("proxy:user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	R save(UserDO user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		user.setPuserId(ShiroUtils.getUserId());
		user.setStatus(1);
		user.setDeptId(1l);
		user.setGmtCreate(new Date());
		user.setUserIdCreate(ShiroUtils.getUserId());
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("proxy:user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(UserDO user) {
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("proxy:user:edit")
	@Log("充值页面")
	@GetMapping("/recharge/{id}")
	String recharge(Model model, @PathVariable("id") Long id) {
		UserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
		return prefix+"/recharge";
	}



	@RequiresPermissions("proxy:user:recharge")
	@Log("用户充值")
	@PostMapping("/rechargeAmt")
	@ResponseBody
	R rechargeAmt(UserRechargeVO userRechargeVO) {
		//2.记录充值金额
		try{
			UserAccountDO userAccountDO=new UserAccountDO();
			userAccountDO.setUserId(userRechargeVO.getUserId());
			UserAccountDO oldUserAccountDO=userAccountService.selectByUserId(userRechargeVO.getUserId());
			long acctId;
			BigDecimal operAmtBefore=BigDecimal.ZERO;
			BigDecimal operAmtAfter=BigDecimal.ZERO;
			if(oldUserAccountDO==null){
				operAmtAfter=operAmtBefore.add(userRechargeVO.getRechargeAmt());
				userAccountDO.setAcctType("BOM");
				userAccountDO.setAcctAmt(operAmtAfter);
				userAccountDO.setAcctAmt1(BigDecimal.ZERO);
				userAccountDO.setAcctAmt2(BigDecimal.ZERO);
				userAccountDO.setAcctAmt3(BigDecimal.ZERO);
				userAccountDO.setAcctAmt4(BigDecimal.ZERO);
				userAccountDO.setModiTime(new Date());
				acctId=userAccountService.save(userAccountDO);
			}else {
				acctId=oldUserAccountDO.getId();
				operAmtBefore=oldUserAccountDO.getAcctAmt();
				operAmtAfter=operAmtBefore.add(userRechargeVO.getRechargeAmt());
				userAccountDO.setId(acctId);
				userAccountDO.setAcctAmt(operAmtAfter);
				userAccountDO.setModiTime(new Date());
				userAccountService.update(userAccountDO);
			}

			//1.记录充值流水
			AccountLogDO accountLogDO=new AccountLogDO();
			accountLogDO.setUserId(userRechargeVO.getUserId());
			accountLogDO.setAcctId(acctId);
			accountLogDO.setOperAmt(userRechargeVO.getRechargeAmt());
			accountLogDO.setAmtDirect("+");
			accountLogDO.setAcctAmtB(operAmtBefore);//充值前金额
			accountLogDO.setAcctAmtA(operAmtAfter);//充值后金额
			accountLogDO.setOperMsg("充值金额"+userRechargeVO.getRechargeAmt());
			accountLogDO.setOperType("RECHARGE");
			accountLogDO.setOperStatus(2);
			accountLogService.save(accountLogDO);
		}catch (Exception e){
			return R.error(e.getMessage());
		}
		return R.ok();
	}



	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = userService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	String personal(Model model) {
		UserDO userDO  = userService.get(getUserId());
		model.addAttribute("user",userDO);
		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}

}
