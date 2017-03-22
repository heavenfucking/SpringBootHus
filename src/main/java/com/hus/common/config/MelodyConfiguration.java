package com.hus.common.config;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.Parameter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by zhu on 2017/2/21.
 */
@Component
public class MelodyConfiguration implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean javaMelody = new FilterRegistrationBean();
        javaMelody.setFilter(new MonitoringFilter());
        javaMelody.setAsyncSupported(true);
        javaMelody.setName("melody");
        javaMelody.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        javaMelody.addInitParameter(Parameter.LOG.getCode(), "true");
        return javaMelody;
    }
}
