package cn.singularity.appsys.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.singularity.appsys.service.UserService;

/**
 * 后台管理基本模块
 * @author zh
 */
@Controller
@RequestMapping("/back/")
public class BackController {
	
	@Autowired
	UserService userService;
	/**
	 * 登陆功能实现
	 * @return 
	 * @author zh
	 */
	@RequestMapping("/dologin")
	public String doLogin() {
		System.out.println("backlog");
		
		userService.login(null);
		return "main";
	}
	
}
