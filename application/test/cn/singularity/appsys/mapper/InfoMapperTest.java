package cn.singularity.appsys.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.common.PageUtil;
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
		PageUtil pageUtil = new PageUtil(20);
		List<Info> list = infoMapper.getList(pageUtil);
		for (Info info : list) {
			System.out.print("id:" + info.getStatus()+" = ");
			System.out.println(info.getStatusname());
			System.out.println(info.getFlatformname());
		}
	}

}
