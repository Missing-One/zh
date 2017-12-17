package cn.singularity.appsys.controller.dev;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.pojo.Version;
import cn.singularity.appsys.service.AppService;
import cn.singularity.appsys.service.VersionService;

/**
 * 开发者的app管理控制器
 * @author zh
 */
@Controller
@RequestMapping("/dev/")
public class AppController {
	
	@Autowired
	AppService appService;
	@Autowired
	VersionService versionService; 
	
	
	/**
	 * 分页工具初始化
	 * 需要抛弃的
	 * @return
	 */
	@ModelAttribute("pageUtil")
	public PageUtility getPageUtil() {
		int count = appService.getCount();
		System.out.println(count);
		return new PageUtility(count);
	}
	
	/**
	 * app信息显示页
	 * @return
	 */
	@RequestMapping("/app/list")
	public String list(String pageIndex, Info appInfo, @ModelAttribute("pageUtil")PageUtility pageUtil, Model model,Map<String,Object> map) {
		System.out.println("pageIndex = "+pageIndex + "-" + appInfo);
		pageUtil.setCurrentPageNo(pageIndex);
		model.addAttribute("query",appInfo);
		
		
		model.addAttribute("appInfoList", appService.appInfoList(appInfo, pageUtil));
		model.addAttribute("statusList", appService.getAllStatus());
		model.addAttribute("flatFormList", appService.getAllFlatform());		
		
		model.addAttribute("categoryLevel1List",appService.getCategoryListByParentId(null));
		
		return "appinfolist";
	}
	
	
	@RequestMapping(value = "/app/appinfoadd",method = RequestMethod.GET)
	public String addAppInfo(Model model){
		model.addAttribute("appVersionList",versionService.getVersionList());
		
		for (Version v : versionService.getVersionList()) {
			System.out.println(v);
		}
		return "appversionadd";
	}
	
	
	@RequestMapping(value = "/app/appinfoadd",method = RequestMethod.PUT)
	public String addAppInfo(Info appInfo){
		
		
		
		return "appversionadd";
	}
	
	
	//----------------------------------------json------------------------------------------------
	/**
	 * 各项分类获取
	 * 跟据父级分类编号parentid
	 * @return
	 */
	@RequestMapping({"/app/list/categ{id}.json"})
	@ResponseBody
	public String getCategory(@PathVariable Long id,Model model) {
		List<Category> list = appService.getCategoryListByParentId(id);
		String jsonString = JSONObject.toJSONString(list);
		System.out.println("jsonStr" + jsonString);
		return jsonString;
	}
	
	
	
	
	
	
}
