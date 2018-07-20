package com.lijm.springmvc;

import com.lijm.springmvc.domain.MyMessageConverter;
import com.lijm.springmvc.intercepter.DemoIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.lijm.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public DemoIntercepter demoIntercepter(){
        return new DemoIntercepter();
    }

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }
    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //addResourceHandler--对外暴露的访问路径
        //addResourceLocations -- 文件存放路径
         registry.addResourceHandler("/access/**").addResourceLocations("classpath:/access/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //增加拦截器
        registry.addInterceptor(demoIntercepter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //增加全局访问跳转
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/toUpload").setViewName("upload");
        registry.addViewController("/converter").setViewName("converter");
        registry.addViewController("/sse").setViewName("sse");
        registry.addViewController("/async").setViewName("async");
    }
     @Override
     public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(converter());
     }

}
