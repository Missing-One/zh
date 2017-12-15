package cn.singularity.appsys.mapper;

import java.util.List;

import cn.singularity.appsys.pojo.Dictionary;

public interface DictionaryMapper {
	
	/**
	 * @author zh
	 */
	List<Dictionary> getAllStatuse();
	
	/**
	 * @author zh
	 */
	List<Dictionary> getAllFlatform();
	
	
	
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}