package cn.singularity.appsys.service;

import cn.singularity.appsys.pojo.User;

/**
 * 用户业务接口
 * @author zh
 */
public interface UserService {
	
	/**
	 * 登陆功能
	 * @return
	 * @author zh
	 */
	User login(User user);
	
	/**
	 * 获取
	 * @author zh
	 */
	User getUserById(Long id);
}
