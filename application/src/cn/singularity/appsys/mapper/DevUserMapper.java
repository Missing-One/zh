package cn.singularity.appsys.mapper;

import cn.singularity.appsys.pojo.DevUser;

public interface DevUserMapper {
	/**
	 * @author zh
	 */
	DevUser selectOne(DevUser record);
	
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}