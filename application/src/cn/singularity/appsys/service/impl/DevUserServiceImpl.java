package cn.singularity.appsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.mapper.DevUserMapper;
import cn.singularity.appsys.pojo.DevUser;
import cn.singularity.appsys.service.DevUserService;
/***
 * 
 * @author zh
 */
@Service
@Transactional
public class DevUserServiceImpl implements DevUserService {

	@Autowired
	DevUserMapper devUserMapper;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public DevUser login(DevUser devUser) {
		return devUserMapper.selectOne(devUser);
	}

}
