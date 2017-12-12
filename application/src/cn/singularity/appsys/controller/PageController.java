package cn.singularity.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String page(@PathVariable String page) {
		System.out.println(124124);
		return page;
	}

	@RequestMapping("/{page}")
	public String asd(@PathVariable String page) {
		System.out.println(124124);
		return page;
	}
}
