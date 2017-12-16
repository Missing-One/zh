package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;

/**
 * app服务类
 * @author zh
 */
public interface AppService {
	
	/**
	 * 带条件获取app所有信息
	 * @return
	 */
	List<Info> appInfoList(Info condition,PageUtility pageUtil);
	
	/**
	 * 获取app的总数
	 */
	int getCount();
	
	/**
	 * 获取所有app的状态
	 * @return
	 */
	List<Dictionary> getAllStatus();
	
	/**
	 * 获取所有app的所属平台
	 * @return
	 */
	List<Dictionary> getAllFlatform();
	
	/**
	 * 根据父级分类的id来获取对应的分类集合
	 * 如果id=null 则默认返回一级分类
	 * @param id 父级分类的id，可以为空
	 * @return
	 */
	List<Category> getCategoryListByParentId(Long id);
}
