package cn.singularity.appsys.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.pojo.Info;

public class InfoMapperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("app-dao.xml");
		infoMapper = app.getBean(InfoMapper.class);
	}	
	static InfoMapper infoMapper;
	@Test
	public void test() {
		PageUtility pageUtil = new PageUtility(20);
		Info info = new Info();
//		info.setFlatformid((long) 3);
		List<Info> list = infoMapper.getAppselect(info,pageUtil);
		for (Info info2 : list) {
			System.out.println(info2.getFlatformid());
		}
	}

}
