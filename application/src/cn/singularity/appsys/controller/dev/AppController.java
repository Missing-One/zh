package cn.singularity.appsys.controller.dev;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Dictionary;
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
	
	/**
	 * 获取app信息添加页码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/app/appinfoadd",method = RequestMethod.GET)
	public String addAppInfo(Model model){
//		model.addAttribute("appVersionList",versionService.getVersionList());
		
		return "appinfoadd";
	}
	
	/**
	 * 添加app信息						 
	 * @param appInfo
	 * @param uploadFile
	 * @param req
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/app/appinfoadd")
	public String addAppInfo(Info appInfo, @RequestParam("file")MultipartFile uploadFile, HttpServletRequest req, HttpSession session) throws IllegalStateException, IOException{
		System.out.println("put");
		
		String path = session.getServletContext().getRealPath(File.separator + "statics" + File.separator + "uploadfiles" );
//		String realSavePath = req.getScheme() + "://"+ req.getServerName() + ":" + req.getServerPort()+req.getContextPath()+"/attachment/securitysupervision/";
		String workPath = session.getServletContext().getRealPath(File.separator);
		File file = new File(path, uploadFile.getOriginalFilename());
		String absPath = file.getPath();
		String relPath = absPath.substring(absPath.lastIndexOf(workPath.substring(workPath.lastIndexOf(File.separator))));
		appInfo.setLogolocpath(absPath);
		appInfo.setLogopicpath(relPath);
		
		if(appService.addApp(appInfo)) {
			if (!file.exists()) {
				file.mkdirs();
			}
			uploadFile.transferTo(file);
			return "redirect:/dev/app/list";
		}else {

			return "appinfoadd";
		}
	}
	
	/**
	 * 获取app的所有版本根据appid
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/app/appversionadd", method = RequestMethod.GET)
	public String getVersion(long id,Model model) {
		List<Version> versions = versionService.getAppVersionListById(id);
		model.addAttribute("appVersionList",versions);
		return "appversionadd";
	}
	
	/**
	 * 为指定的app添加版本信息根据appid
	 * @param version
	 * @param model
	 * @param session
	 * @param uploadFile
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/app/addversionsave", method = RequestMethod.POST)
	public String addVersion(Version version, Model model, HttpSession session, @RequestParam("file")MultipartFile uploadFile) throws IllegalStateException, IOException {
		System.out.println(version);
		
		String path = session.getServletContext().getRealPath(File.separator + "statics" + File.separator + "uploadfiles" );
//		String realSavePath = req.getScheme() + "://"+ req.getServerName() + ":" + req.getServerPort()+req.getContextPath()+"/attachment/securitysupervision/";
		String workPath = session.getServletContext().getRealPath(File.separator);
		File file = new File(path, uploadFile.getOriginalFilename());
		String absPath = file.getPath();
		String relPath = absPath.substring(absPath.lastIndexOf(workPath.substring(workPath.lastIndexOf(File.separator))));
		version.setApkfilename(file.getName());
		version.setApklocpath(absPath);
		version.setDownloadlink(relPath);
		version.setCreationdate(new Date());
		model.addAttribute("id",version.getAppid());
		uploadFile.transferTo(file);
		if(versionService.addVersion(version)) {
			
			return "redirect:/dev/app/appversionadd";
		} else {
			model.addAttribute("appVersion",version);
			return "forward:/dev/app/appversionadd";
		}
	}
	
	/**
	 * 修改版本页
	 * @param vid
	 * @param aid
	 * @param model
	 * @return
	 */
	@RequestMapping("app/appversionmodify")
	public String modifyAppVersion(Long vid,Long aid,Model model) {
		List<Version> versions = versionService.getAppVersionListById(aid);
		model.addAttribute("appVersionList",versions);
		Version vers = versionService.getVersionById(vid);
		System.out.println(vers);
		model.addAttribute("appVersion",vers);
		
//		versionService
		return "appversionmodify";
	}
	
	/**
	 * 修改版本信息
	 * @param version
	 * @param model
	 * @param session
	 * @param uploadFile
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/app/appversionmodifysave", method = RequestMethod.POST)
	public String modifyVersion(Version version, Model model, HttpSession session, @RequestParam("file")MultipartFile uploadFile) throws IllegalStateException, IOException {
		System.out.println(version);
		if(version.getApkfilename() != null && !version.getApkfilename().equals(uploadFile.getOriginalFilename())) {
			String path = session.getServletContext().getRealPath(File.separator + "statics" + File.separator + "uploadfiles" );
//			String realSavePath = req.getScheme() + "://"+ req.getServerName() + ":" + req.getServerPort()+req.getContextPath()+"/attachment/securitysupervision/";
			String workPath = session.getServletContext().getRealPath(File.separator);
			File file = new File(path, uploadFile.getOriginalFilename());
			String absPath = file.getPath();
			String relPath = absPath.substring(absPath.lastIndexOf(workPath.substring(workPath.lastIndexOf(File.separator))));
			version.setApkfilename(file.getName());
			version.setApklocpath(absPath);
			version.setDownloadlink(relPath);
			version.setCreationdate(new Date());
			uploadFile.transferTo(file);
		}
		model.addAttribute("vid", version.getId());
		model.addAttribute("aid", version.getAppid());
		
		if(versionService.modifyVersion(version)) {
			return "redirect:/dev/app/appversionmodify";
		} else {
			model.addAttribute("appVersion",version);
			return "forward:/dev/app/appversionmodify";
		}
//		return "appinfolistq";
	}
	
	/**
	 * 根据app的编号id获取基本信息和版本信息
	 * @return
	 */
	@RequestMapping("app/appview/{id}")
	public String getAppView(@PathVariable Long id, Model model) {
		Info appInfo = appService.getAppInfoById(id);
		List<Version> versions = versionService.getAppVersionListById(appInfo.getId());
		model.addAttribute("appInfo", appInfo);
		model.addAttribute("appVersionList", versions);
		return "appinfoview";
		
	}
	
	@RequestMapping("/app/appinfomodify")
	public String modifyAppInfo(Long id, Model model) {
		Info app = appService.getAppInfoById(id);
		model.addAttribute("appInfo",app);
		return "appinfomodify";
	}
	
	@RequestMapping("/app/appinfomodifysave")
	public String modifyAppInfo(Info app, Model model, HttpSession session, @RequestParam("file")MultipartFile uploadFile) {
		System.out.println(app);
		int modifyResultState = appService.modifyAppInfoById(app);
		model.addAttribute("id",app.getId());
		if (modifyResultState > -1) {
			return "redirect:/dev/app/appinfomodify";
		} else {
			return "forward:/dev/app/appinfomodify";
		}
		
	}
	
	
	//----------------------------------------json------------------------------------------------
	/**
	 * 各项分类获取
	 * 跟据父级分类编号parentid
	 * @return
	 */
	@RequestMapping({"/app/list/categ{id}.json"})
	@ResponseBody
	public String getCategory(@PathVariable String id,Model model) {
		List<Category> list = appService.getCategoryListByParentId(id.equals("null")? null: Long.parseLong(id));
		String jsonString = JSONObject.toJSONString(list);
		System.out.println("jsonStr" + jsonString);
		return jsonString;
	}
	
	/**
	 * 获取app所属的平台集合
	 * @return
	 */
	@RequestMapping({"/app/list/flatformlist.json"})
	@ResponseBody
	public String getFlatFormList() {
		System.out.println("平台-----");
		List<Dictionary> flatforms = appService.getAllFlatform();
		String jsonString = JSONObject.toJSONString(flatforms);
		System.out.println("jsonStr" + jsonString);
		return jsonString;
	}
	
	/**
	 * 删除app信息包括所拥有的版本信息
	 * @param id
	 * @return
	 */
	@RequestMapping("app/delapp.json")
	@ResponseBody
	public String delApp(Long id){
		System.out.println("id " + id);
		int delVersionState = versionService.delVersionListByAppId(id);
		
		if(delVersionState > -1) {
			int delAppInfoState = appService.delAppInfoById(id);
			// 大于0：删除成功
			// 等于-1：删除失败
			// 等于0：app信息不存在
			if (delAppInfoState > 0) {
				return "true";
			} else if (delAppInfoState == -1) {
				return "false";
			}else if (delAppInfoState == 0) {
				return "'notexits'";
			}
		}
		return "false";
	}
	
	
}
