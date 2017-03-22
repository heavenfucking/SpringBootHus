package com.hus.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhh on 2017/3/3.
 */
//@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new myInterceptor());
    }

    private class myInterceptor extends HandlerInterceptorAdapter{
        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            logger.info("remoteAddr="+request.getRemoteAddr()+" request="+request.getRequestURI());
            return true;
        }
    }
}