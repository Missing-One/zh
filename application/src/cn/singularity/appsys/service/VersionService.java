package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.pojo.Version;

/**
 * 版本服务类
 * @author zh
 */
public interface VersionService {
	
	/**
	 * 获取到所有版本信息
	 */
	List<Version> getVersionList();
}
