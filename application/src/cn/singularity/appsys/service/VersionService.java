package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.pojo.Version;

/**
 * 版本服务类
 * @author zh
 */
public interface VersionService {
	
	/**
	 * 根据版本id获取版本信息
	 * @return
	 */
	Version getVersionById(Long id);
	/**
	 * 获取到所有版本信息
	 */
	List<Version> getVersionList();
	
	/**
	 * 获取app版本集合根据指定的appid
	 * @param id
	 * @return
	 */
	List<Version> getAppVersionListById(long appId);
	
	/**
	 * 为指定app添加一条版本信息
	 * @return
	 */
	boolean addVersion(Version version);
	
	/**
	 * 根据版本编号id修改一条版本信息
	 * @return
	 */
	boolean modifyVersion(Version version);
	
	/**
	 * 删除指定app的 所有版本
	 * @return
	 */
	int delVersionListByAppId(Long id);
}
