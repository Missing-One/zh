package cn.singularity.appsys.mapper;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.pojo.Category;
/**
 * 测试
 * @author zh
 */
public class CategoryMapperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("app-dao.xml");
		catMapper = app.getBean(CategoryMapper.class);
	}
	static CategoryMapper catMapper;

	@Test
	public void test() {
		List<Category> list = catMapper.getCategoryListByParentId(null);
//		for (Category category : list) {
//			System.out.println(category.getCategoryname());
//		}
		String workPath = System.class.getClassLoader().getResource(File.separator).getPath();
		System.out.println(workPath);
	}

}
