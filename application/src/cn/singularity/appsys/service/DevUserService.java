package cn.singularity.appsys.service;

import cn.singularity.appsys.pojo.DevUser;

/**
 * 开发者服务接口
 * @author zh
 */
public interface DevUserService {
	
	/**
	 * 开发者登陆功能
	 * @return
	 */
	DevUser login(DevUser devUser);
	
}
