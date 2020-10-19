package com.example.demo.config;

import java.util.Collections;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XrayConfiguration {

    @Value("${spring.application.name:app}")
    private String applicationName;

    @Bean
    public FilterRegistrationBean awsxRayServletFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AWSXRayServletFilter(applicationName));
        bean.setUrlPatterns(Collections.singleton("/*"));
        return bean;
    }

    // @Bean
    // public Filter TracingFilter() {
    //     // DynamicSegmentNamingStrategy 已經 Deprecated
    //     return new AWSXRayServletFilter(new DynamicSegmentNamingStrategy("MyApp", "*.example.com"));
    // }
}