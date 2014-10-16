package no.itera.skilldb.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by john.bye on 10/16/14.
 */
public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        // Create ApplicationContext. I'm using the
        // AnnotationConfigWebApplicationContext to avoid using beans xml files.
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.register(EmbeddedApplicationConfig.class);

        // // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(ctx));

        // Add the servlet mapping manually and make it initialize automatically
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(ctx));
        servlet.addMapping("/api/*");
        servlet.setLoadOnStartup(1);

        //servletContext.addFilter("simpleCORSFilter", SimpleCORSFilter.class).addMappingForUrlPatterns(null, false, "/*");

    }
}