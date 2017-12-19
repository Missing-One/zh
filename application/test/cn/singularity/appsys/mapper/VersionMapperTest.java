package cn.singularity.appsys.mapper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.pojo.Version;

public class VersionMapperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("app-dao.xml");
		versionMapper = app.getBean(VersionMapper.class);
	}
	static VersionMapper versionMapper;
	@Test
	public void test() {
		
		for (Version v : versionMapper.selectVersionListByAppId(56)) {
			System.out.println(v.getPublishstatusname());
		}
	}
	
	

}
