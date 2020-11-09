package com.example.demo.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.plugins.ElasticBeanstalkPlugin;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

// import ch.qos.logback.access.servlet.TeeFilter;

@Configuration
public class XrayConfiguration {

    @Value("${spring.application.name:app}")
    private String applicationName;

    // @Value("classpath:sampling-rules.json")
    // private Resource resource;

    static {
        
        try {
            File file = ResourceUtils.getFile("classpath:sampling-rules.json");
            System.out.println(file);
            AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new EC2Plugin()).withPlugin(new ElasticBeanstalkPlugin());
            builder.withSamplingStrategy(new LocalizedSamplingStrategy(file.toURI().toURL()));
            AWSXRay.setGlobalRecorder(builder.build());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
        
      }

    @Bean
    public FilterRegistrationBean awsxRayServletFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new AWSXRayServletFilter(applicationName));
        bean.setUrlPatterns(Collections.singleton("/*"));

        // bean.setFilter(new TeeFilter());

        return bean;
    }

    // @Bean
    // public Filter TracingFilter() {
    //     // DynamicSegmentNamingStrategy 已經 Deprecated
    //     return new AWSXRayServletFilter(new DynamicSegmentNamingStrategy("MyApp", "*.example.com"));
    // }
}