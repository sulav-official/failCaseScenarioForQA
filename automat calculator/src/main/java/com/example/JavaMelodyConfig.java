package com.example;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;
import net.bull.javamelody.MonitoringFilter;

@Configuration
public class JavaMelodyConfig {

    @Bean
    public FilterRegistrationBean<Filter> monitoringFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        // Cast MonitoringFilter to javax.servlet.Filter
        registrationBean.setFilter((Filter) new MonitoringFilter());
        registrationBean.addUrlPatterns("/*");  // Apply filter to all URLs
        return registrationBean;
    }
}
