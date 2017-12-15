package cn.singularity.appsys.controller.dev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.service.AppService;

/**
 * 开发者的app管理控制器
 * @author zh
 */
@Controller
@RequestMapping("/dev/")
public class AppController {
	
	@Autowired
	AppService appService;
	
	/**
	 * 分页工具初始化
	 * 需要抛弃的
	 * @return
	 * @author zh
	 */
	@ModelAttribute("pageUtil")
	public PageUtil getPageUtil() {
		int count = appService.getCount();
		System.out.println(count);
		return new PageUtil(count);
	}
	/**
	 * 
	 * @return
	 * @author zh
	 */
	@RequestMapping("/app/list/{pageNo}")
	public String list(@PathVariable String pageNo, @ModelAttribute("pageUtil")PageUtil pageUtil, Model model) {
		
		pageUtil.setCurrentPageNo(pageNo);
		model.addAttribute("appInfoList", appService.appInfoList(pageUtil));
		
		model.addAttribute("statusList", appService.getAllStatus());
		model.addAttribute("flatFormList", appService.getAllFlatform());		
		
		return "appinfolist";
	}
	
	
	
	
	
	
	
	
	
}
