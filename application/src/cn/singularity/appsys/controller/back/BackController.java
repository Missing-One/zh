package cn.singularity.appsys.controller.back;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.singularity.appsys.pojo.User;
import cn.singularity.appsys.service.UserService;

/**
 * 后台管理基本模块
 * @author zh
 */
@Controller
@RequestMapping("/back/")
@SessionAttributes({"loggedUser"})
public class BackController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 登陆功能实现
	 * @return 
	 * @author zh
	 */
	@RequestMapping("/dologin")
	public String doLogin(User user,Model model) {
		System.out.println("backlog");
		System.out.println(user);
		user = userService.login(user);
		System.out.println(user);
		
		if(user != null) {
			model.addAttribute("loggedUser", user);
			return "forward:/back/main"; 
		} else {
			return "redirect:/back-login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/back-login";
	}
	
	/**
	 * 后台主页
	 * @return
	 * @author zh
	 */
	@RequestMapping("/main")
	public String main () {
		return "main";
	}
	
}
