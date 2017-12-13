package cn.singularity.appsys.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理基本模块
 * @author zh
 */
@Controller
@RequestMapping("/back/")
public class BackController {
	
	/**
	 * 登陆功能实现
	 * @return 
	 * @author zh
	 */
	@RequestMapping("/dologin")
	public String doLogin() {
		System.out.println("backlog");
		return "main";
	}
	
}
