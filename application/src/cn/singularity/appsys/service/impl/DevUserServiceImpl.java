package cn.singularity.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.mapper.DevUserMapper;
import cn.singularity.appsys.pojo.DevUser;
import cn.singularity.appsys.service.DevUserService;
/***
 * 开发者账户服务
 * @author zh
 */
@Service
@Transactional
public class DevUserServiceImpl implements DevUserService {

	@Autowired
	DevUserMapper devUserMapper;
	
	/**
	 * 根据账号和密码匹配用户
	 * @param devUser devCode和devPassword 两个属性不能为空,登陆必须项
	 * @author zh
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public DevUser login(DevUser devUser) {
		return devUserMapper.selectOne(devUser);
	}

}
