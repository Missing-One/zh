package cn.singularity.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.singularity.appsys.mapper.UserMapper;
import cn.singularity.appsys.pojo.User;
import cn.singularity.appsys.service.UserService;

/**
 * 用户业务接口的一个实现类
 * @author zh
 */
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user) {
		return userMapper.selectOne(user);
	}
	

}
