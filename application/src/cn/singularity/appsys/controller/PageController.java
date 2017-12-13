package cn.singularity.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 * 负责完成页面的跳转 
 * @author zh
 */
@Controller
public class PageController {
	
	/**
	 * 默认根路径,跳转到主页
	 * @return 主页
	 * @author zh
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	/**
	 * 使用rest风格来跳转到相应的页面
	 * @param page	页面的逻辑视图名
	 * @return 页面的逻辑视图名
	 * @author zh
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable String page){
		System.out.println("page:" + page);
		return page;
	}
	
	@RequestMapping("/dev-login")
	public String dev_login(){
		return "devlogin";
	}
	@RequestMapping("/back-login")
	public String backend_login(){
		return "backendlogin";
	}
}
