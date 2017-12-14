package cn.singularity.appsys.service;

import cn.singularity.appsys.pojo.User;

/**
 * 用户业务接口
 * @author mk
 */
public interface UserService {
	
	/**
	 * 登陆功能
	 * @return
	 * @author mk
	 */
	User login(User user);
	
	/**
	 * 获取
	 */
	User getUserById(Long id);
}
