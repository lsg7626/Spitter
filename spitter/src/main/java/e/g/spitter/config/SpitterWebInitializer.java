package e.g.spitter.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   // AbstractAnnotationConfigDispatcherServletInitializer 는 자동으로 DispatcherServlet, ContextLoaderListener을 자동적으로 등록한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
 	  return new String[] { "/" };
	}
  
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spitter/uploads", 2097152, 4194304, 0)); // 업로드 되는 파일의 크기를 2MB로 제한, 전체 요청의 크기를 4MB로 제한 
	}
  
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new MyFilter()	};
	}
}
