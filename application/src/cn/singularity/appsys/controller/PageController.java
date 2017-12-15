package cn.singularity.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 椤甸潰鎺у埗鍣�
 * 璐熻矗瀹屾垚椤甸潰鐨勮烦杞�
 * @author zh
 */
@Controller
public class PageController {
	
	/**
	 * 榛樿鏍硅矾寰�璺宠浆鍒颁富椤�
	 * @return 涓婚〉
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	/**
	 * 浣跨敤rest椋庢牸鏉ヨ烦杞埌鐩稿簲鐨勯〉闈�
	 * @param page	椤甸潰鐨勯�杈戣鍥惧悕
	 * @return 椤甸潰鐨勯�杈戣鍥惧悕
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable String page){
		System.out.println("page:" + page);
		return page;
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/dev-login")
	public String dev_login(){
		return "devlogin";
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/back-login")
	public String backend_login(){
		return "backendlogin";
	}
}