package com.example.todo.config;

import com.example.todo.security.filter.LoginCheckFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<LoginCheckFilter> loginCheckFilter() {
        FilterRegistrationBean<LoginCheckFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginCheckFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
