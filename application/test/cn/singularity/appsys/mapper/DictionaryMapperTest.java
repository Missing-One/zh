package cn.singularity.appsys.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.pojo.Dictionary;
/**
 * @author zh
 */
public class DictionaryMapperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("app-dao.xml");
		dicMapper = app.getBean(DictionaryMapper.class);
	}
	static DictionaryMapper dicMapper;
	@Test
	public void testGetAllStatuse() {
		System.out.println("statuses-------------");
		List<Dictionary> list = dicMapper.getAllStatuse();
		for (Dictionary dictionary : list) {
			System.out.println(dictionary.getValuename());
		}
	}

	@Test
	public void testGetAllFlatform() {
		System.out.println("flatforms-------------");
		List<Dictionary> list = dicMapper.getAllFlatform();
		for (Dictionary dictionary : list) {
			System.out.println(dictionary.getValuename());
		}
	}

}
