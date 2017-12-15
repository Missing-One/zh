package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;

/**
 * app服务类
 * @author zh
 */
public interface AppService {
	
	/**
	 * 获取app所有信息
	 * @return
	 * @author zh
	 */
	List<Info> appInfoList(PageUtil pageUtil);
	
	/**
	 * 获取app的总数
	 * @author zh
	 */
	int getCount();
	
	/**
	 * 获取所有app的状态
	 * @return
	 * @author zh
	 */
	List<Dictionary> getAllStatus();
	
	/**
	 * 获取所有app的所属平台
	 * @return
	 * @author zh
	 */
	List<Dictionary> getAllFlatform();
}
