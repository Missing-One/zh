package cn.singularity.appsys.controller.back;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;







import com.alibaba.fastjson.JSONObject;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.mapper.CategoryMapper;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.pojo.User;
import cn.singularity.appsys.service.AppService;
import cn.singularity.appsys.service.InfoService;
import cn.singularity.appsys.service.UserService;

/**
 * 后台管理基本模块
 * @author zh
 */
@Controller
@RequestMapping("/back/")
@SessionAttributes({"loggedUser","appInfoList","flatFormList","categoryLevel1List"})
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
	 *@author YJ,xh
	 */
	@RequestMapping("/app/list")
	public String appinfo(Model model){
		List<Info> list=infoService.getinfoList();
		model.addAttribute("appInfoList", list);
		List<Dictionary> list2=appService.getAllFlatform();
		model.addAttribute("flatFormList", list2);
		List<Category> list3=appService.getCategoryListByParentId(null);
		model.addAttribute("categoryLevel1List",list3);
		return "applist";
		
	}

	@RequestMapping({"/categorylevellist"})
	@ResponseBody
	public String bindl2(String pid){
		List<Category> list = appService.getCategoryListByParentId(pid.equals("null")? null: Long.parseLong(pid));
		String jsonString = JSONObject.toJSONString(list);
		System.out.println("jsonStr" + jsonString);
		return jsonString;
	}

	@RequestMapping("/app/listselect")	
	public String getselect(Model model,Info info,PageUtility pageUtility, String pageIndex){
		//数量
		System.out.println("pageUtility" + pageUtility);
		System.out.println(pageUtility);
		pageUtility.setTotalCount(infoService.getAppCount());
		pageUtility.setCurrentPageNo(pageIndex);

		List<Info> list=infoService.getAppselect(info,pageUtility);
		model.addAttribute("appInfoList", list);
		model.addAttribute("queryCondition", info);
		System.out.println(list.size());
		model.addAttribute("pages", pageUtility);
		
		model.addAttribute("flatFormList", appService.getAllFlatform());
		model.addAttribute("categoryLevel1List",appService.getCategoryListByParentId(null));
		
		return "applist";
	}
}
