package com.bootdo.system.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import com.bootdo.system.domain.MenuDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.enums.RoleCodeEnum;
import com.bootdo.system.service.MenuService;
import com.bootdo.system.service.SmsService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.CustResultVo;
import com.bootdo.system.vo.UserRegisterVo;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;
	@Autowired
	FileService fileService;
	@Autowired
	SmsService smsService;
	@Autowired
	UserService userService;
	@GetMapping({ "/", "" })
	String welcome(Model model) {

		return "login";
	}

	@Log("请求访问主页")
	@GetMapping({ "/index" })
	String index(Model model) {
		String roleCode=getRoleCode();
		if( RoleCodeEnum.NORMAL.getCode().equals(roleCode)){
			CustResultVo custResultVo=smsService.findByUser(getUserId());
			model.addAttribute("custResultVo", custResultVo);
			return "index_v2";
		}else{
			List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
			model.addAttribute("menus", menus);
			model.addAttribute("name", getUser().getName());
			FileDO fileDO = fileService.get(getUser().getPicId());
			if(fileDO!=null&&fileDO.getUrl()!=null){
				if(fileService.isExist(fileDO.getUrl())){
					model.addAttribute("picUrl",fileDO.getUrl());
				}else {
					model.addAttribute("picUrl","/img/photo_s.jpg");
				}
			}else {
				model.addAttribute("picUrl","/img/photo_s.jpg");
			}
			model.addAttribute("username", getUser().getUsername());
			return "index_v1";
		}
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@GetMapping("/register")
	String register() {
		return "register";
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
	R ajaxLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}


	@Log("用户注册")
	@PostMapping("/register")
	@ResponseBody
	R ajaxRregister(UserRegisterVo userRegisterVo) {
		//1.查询有没有注册
		if(!userRegisterVo.getLoginPass1().equals(userRegisterVo.getLoginPass2())){
			return R.error("两次密码不一致");
		}
		try{
			UserDO userDO=new UserDO();
			userDO.setUsername(userRegisterVo.getLoginNo());
			userDO.setName(userRegisterVo.getLoginNo());
			userDO.setPassword(MD5Utils.encrypt(userRegisterVo.getLoginNo(), userRegisterVo.getLoginPass1()));
			userDO.setStatus(1);
			userDO.setDeptId(1l);
			userDO.setGmtCreate(new Date());
			userDO.setInviteCode(userRegisterVo.getInvitedCode());
			userService.register(userDO);
		}catch (BDException e){
			return R.error(e.getCode(),e.getMsg());
		}catch (Exception e){
			return R.error("内部异常,请联系管理员"+e.getMessage());
		}
		return R.ok("注册成功");
	}

}
