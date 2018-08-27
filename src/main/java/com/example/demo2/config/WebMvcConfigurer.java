package com.example.demo2.config;

import com.example.demo2.common.StudentInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

//@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void  addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**");
        //registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**").addPathPatterns("/teacher/**");
        super.addInterceptors(registry);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //super.configureContentNegotiation(configurer);
        configurer.favorPathExtension(false);
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
}
