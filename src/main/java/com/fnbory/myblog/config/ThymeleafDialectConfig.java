package com.fnbory.myblog.config;


import com.fnbory.myblog.config.thymeleaf.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ThymeleafDialectConfig {
	@Bean
	public ThSysDialect thSysDialect() {
		return new ThSysDialect();
	}
}
