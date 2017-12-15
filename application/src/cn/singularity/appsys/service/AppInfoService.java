package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;

/**
 * app信息服务类
 * @author zh
 */
public interface AppInfoService {
	
	/**
	 * 获取app所有信息
	 * @return
	 * @author zh
	 */
	List<Info> getList(PageUtil pageUtil);
	
	/**
	 * 获取app信息总数
	 * @author zh
	 */
	int getCount();
	
	/**
	 * 获取所有app的状态
	 * @return
	 * @author zh
	 */
	List<Dictionary> getAllStatus();
}
