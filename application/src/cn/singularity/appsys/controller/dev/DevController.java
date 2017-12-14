package cn.singularity.appsys.controller.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.singularity.appsys.pojo.DevUser;
import cn.singularity.appsys.service.DevUserService;

/**
 * 开发基本模块
 * @author zh
 */
@Controller
@RequestMapping("/dev/")
@SessionAttributes({"loggedDevUser"})
public class DevController {
	
	@Autowired
	DevUserService devUserService; 
	
	/**
	 * 登陆功能实现
	 * @return
	 * @author zh
	 */
	@RequestMapping("/dologin")
	public String doLogin(DevUser devUser,Model model) {
		System.out.println("devlog");
		devUser = devUserService.login(devUser);
		if (devUser != null) {
			model.addAttribute("loggedDevUser",devUser);
			return "main";
		} else {
			return "redirect:/dev-login";
		}
	}
	/**
	 * 开发主页
	 * @return
	 * @author zh
	 */
	@RequestMapping("/main")
	public String main () {
		return "main";
	}
	/**
	 * @param session
	 * @return
	 * @author zh
	 */
	@RequestMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/dev-login";
	}
}
