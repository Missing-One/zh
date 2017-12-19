package cn.singularity.appsys.intercept;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

/**
 * rest风格文件上传支持
 * @author zh
 */
public class RestFileFilter extends OncePerRequestFilter{
	

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain child)
			throws ServletException, IOException {
		String contentType = req.getContentType();
		
		if(contentType != null && !"".equals(contentType.trim()) && contentType.contains("multipart/form-data")) {
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext(),"org.springframework.web.servlet.FrameworkServlet.CONTEXT.springMVC");
			MultipartResolver multipartResolver = webApplicationContext.getBean("multipartResolver",MultipartResolver.class);
			child.doFilter(multipartResolver.resolveMultipart(req), resp);
		}else {
			child.doFilter(req, resp);
		}
	}

}
