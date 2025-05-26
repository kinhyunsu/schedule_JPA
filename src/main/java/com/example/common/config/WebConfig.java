package com.example.common.config;


import com.example.common.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<Filter> customFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoginFilter());

        registrationBean.addUrlPatterns("/*"); // 전체 경로 필터링

        registrationBean.setOrder(1); // 필터 실행 순서 설정 (숫자가 낮을수록 먼저 실행됨)

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        filterFilterRegistrationBean.setOrder(2);
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}