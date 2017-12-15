package cn.singularity.appsys.mapper;

import java.util.List;

import cn.singularity.appsys.pojo.Dictionary;

public interface DictionaryMapper {
	
	/**
	 */
	List<Dictionary> getAllStatuse();
	
	/**
	 */
	List<Dictionary> getAllFlatform();
	
	
	
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}