package cn.singularity.appsys.intercept;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		String devUsername = (String)request.getSession().getAttribute("devUsername");
		if (username == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/backendlogin.jsp").forward(request, response);
			return false;
		} else if (devUsername == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/devlogin.jsp").forward(request, response);
			return false;
		}
		return true;
	}
	
	
}
