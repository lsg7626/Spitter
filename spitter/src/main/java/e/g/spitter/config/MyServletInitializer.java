package e.g.spitter.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class); // 서블릿 등록
		myServlet.addMapping("/custom/**"); // 서블릿 매핑
		
		//javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class); // 필터 등록
		
		//filter.addMappingForUrlPatterns(null, false, "/custom/*"); // 필터 매핑 추가
		
		// AbstractAnnotationConfigDispatcherServletInitializer 에서 getServletFilter 메소드 오버라이드를 통해 필터 등록 가능
	}
}
