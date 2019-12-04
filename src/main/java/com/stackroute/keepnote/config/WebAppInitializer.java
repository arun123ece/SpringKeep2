package com.stackroute.keepnote.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/*This class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
 * class in Servlet 3.0+ environments in order to configure the ServletContext 
 * programmatically -- as opposed to the traditional web.xml-based approach. By overriding the methods of
 * class, we can define the Configuration classes and root mapping so that our application can gets
 * into spring.*/
 

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {ApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}
}



/*package com.stackroute.keepnote.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
public class WebAppInitializer implements WebApplicationInitializer{
    public void onStartup(ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(WebMvcConfig.class);
        webCtx.setServletContext(ctx);
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}*/