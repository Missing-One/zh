package cn.singularity.appsys.mapper;

import cn.singularity.appsys.pojo.User;

public interface UserMapper {
	
	User selectOne(User record);
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}