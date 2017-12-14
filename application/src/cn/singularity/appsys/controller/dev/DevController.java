package cn.singularity.appsys.controller.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 开发基本模块
 * @author zh
 */
@Controller
@RequestMapping("/dev/")
public class DevController {
	
	/**
	 * 登陆功能实现
	 * @return
	 * @author zh
	 */
	@RequestMapping("/dologin")
	public String doLogin() {
		System.out.println("devlog");
		return "main";
	}
	
	@RequestMapping("/main")
	public String main () {
		return "main";
	}
}
