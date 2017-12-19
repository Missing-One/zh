package cn.singularity.appsys.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.singularity.appsys.pojo.DevUser;
import cn.singularity.appsys.pojo.User;

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
//		DevUser user = (DevUser)request.getSession().getAttribute("loggedUser");
//		User devUser = (User)request.getSession().getAttribute("loggedDevUser");
		//System.out.println("username" + username + " -- devUsername" + devUsername);
		
//		if (user == null || user.getId() == null) {
//			request.getRequestDispatcher("/WEB-INF/jsp/backendlogin.jsp").forward(request, response);
//			response.sendRedirect("/back-login");
//			return false;
//		} else if (devUser == null || devUser.getId() == null) {
//			request.getRequestDispatcher("/WEB-INF/jsp/devlogin.jsp").forward(request, response);
//			response.sendRedirect("/dev-login");
//			return false;
//		}
		return true;
	}
	
	
}
