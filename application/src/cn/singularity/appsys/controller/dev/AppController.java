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
import cn.singularity.appsys.service.AppInfoService;

/**
 * 开发者的app管理控制器
 * @author zh
 */
@Controller
@RequestMapping("/dev/")
public class AppController {
	
	@Autowired
	AppInfoService appInfoService;
	
	/**
	 * @return
	 * @author zh
	 */
	@RequestMapping("/app/list/{pageNo}")
	public String list(@PathVariable String pageNo, @ModelAttribute("pageUtil")PageUtil pageUtil, Model model) {
		System.out.println("show list pageutil:" + pageUtil);
		pageUtil.setCurrentPageNo(pageNo);
		List<Info> list = appInfoService.getList(pageUtil);
		
		model.addAttribute("appInfoList", list);
		return "appinfolist";
	}
	
	@ModelAttribute("pageUtil")
	public PageUtil getPageUtil() {
		int count = appInfoService.getCount();
		System.out.println(count);
		return new PageUtil(count);
	}
}
