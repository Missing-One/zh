package cn.singularity.appsys.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登陆拦截器
 * 负责拦截后台管理员或者开发者操作时的登陆验证
 * 
 * @author zh
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		String devUsername = (String)request.getSession().getAttribute("devUsername");
		System.out.println("username" + username + " -- devUsername" + devUsername);
//		if (username == null) {
//			request.getRequestDispatcher("/WEB-INF/jsp/backendlogin.jsp").forward(request, response);
//			return false;
//		} else if (devUsername == null) {
//			request.getRequestDispatcher("/WEB-INF/jsp/devlogin.jsp").forward(request, response);
//			return false;
//		}
		return true;
	}
	
	
}
