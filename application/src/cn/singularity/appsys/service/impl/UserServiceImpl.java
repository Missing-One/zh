package cn.singularity.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.mapper.UserMapper;
import cn.singularity.appsys.pojo.User;
import cn.singularity.appsys.service.UserService;

/**
 * 用户业务接口的一个实现类
 * @author zh
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public User login(User user) {
		return userMapper.selectOne(user);
	}

	@Override
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	

}
