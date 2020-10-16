package com.example.demo.config;

import java.util.Collections;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XrayConfiguration {

    @Bean
    public FilterRegistrationBean awsxRayServletFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AWSXRayServletFilter("xray-sample"));
        bean.setUrlPatterns(Collections.singleton("/*"));
        return bean;
    }
}