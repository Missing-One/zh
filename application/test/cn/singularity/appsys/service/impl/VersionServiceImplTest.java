package cn.singularity.appsys.service.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.singularity.appsys.mapper.VersionMapper;
import cn.singularity.appsys.service.VersionService;

public class VersionServiceImplTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("app-dao.xml","app-service.xml");
		versionMapper = app.getBean(VersionService.class);
	}
	static VersionService versionMapper;
	@Test
	public void test() {
	}

}
