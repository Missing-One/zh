package cn.singularity.appsys.utils;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class AppViewResolver extends UrlBasedViewResolver{

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		System.out.println(viewName);
		return super.buildView(viewName);
	}
	
}
