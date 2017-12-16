package cn.singularity.appsys.controller.back;

import java.util.List;
import java.util.Map;












import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.singularity.appsys.pojo.DevUser;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.pojo.User;
import cn.singularity.appsys.service.AppService;
import cn.singularity.appsys.service.InfoService;
import cn.singularity.appsys.service.UserService;
import cn.singularity.appsys.service.impl.AppServiceImpl;

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
	@Autowired
	InfoService infoService;
	@Autowired
	AppService appService;
	
	
	
	/**
	 * 登陆功能实现
	 * @return 
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
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/back-login";
	}
	
	/**
	 * 后台主页
	 * @return
	 */
	@RequestMapping("/main")
	public String main () {
		return "main";
	}
	
	/**
	 *@author YJ
	 */
	@RequestMapping("/app/list")
	public String appinfo(HttpSession session){
		List<Info> list=infoService.getinfoList();
		session.setAttribute("appInfoList", list);
		List<Dictionary> list2=appService.getAllFlatform();
		session.setAttribute("flatFormList", list2);
		return "applist";
		
	}
	
	

	@RequestMapping(value="/categorylevellist")
	@ResponseBody
	public String bindSelect(String pid){
		System.out.println("pid"+"========="+pid);
		
		
		
		return "applist";
		
		
	}
	
	
	
	
	
	
	
	
}
