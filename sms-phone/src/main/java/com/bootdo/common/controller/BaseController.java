package com.bootdo.common.controller;

import com.bootdo.system.domain.RoleDO;
import com.bootdo.system.domain.UserToken;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

@Controller
public class BaseController {
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}

	public String getRoleCode(){
		Long userId=getUser().getUserId();
		UserDO userDO=userService.get(userId);
		return userDO.getRoleCode();
	}
}