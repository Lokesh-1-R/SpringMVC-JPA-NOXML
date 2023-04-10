package com.stackroute.keepnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.stackroute.keepnote")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalresourceviewresolver =new InternalResourceViewResolver();
		internalresourceviewresolver.setPrefix("/WEB-INF/views/");
		internalresourceviewresolver.setSuffix(".jsp");
		return internalresourceviewresolver;
	}

}
