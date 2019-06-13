package com.fnbory.myblog.config;

import com.fnbory.myblog.interceptor.IndexInterceptor;
import com.fnbory.myblog.interceptor.InstallInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements  WebMvcConfigurer {
    @Autowired
    private IndexInterceptor indexInterceptor;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 通过addResourceHandler添加资源映射路径，然后通过addResourceLocations来指定路径。可以访问自定义upload文件夹
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/")
                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/mayday/upload/");
        registry.addResourceHandler("/source/**").addResourceLocations("classpath:/templates/themes/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InstallInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/install").excludePathPatterns("/install/execute").excludePathPatterns("/static/**").excludePathPatterns("/templates/themes");
        registry.addInterceptor(indexInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**").excludePathPatterns("/templates/themes");
    }
//
//
//
//
//    @Bean
//    public  WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//
//        };
//    }
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }


}
