package com.np.wearound;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig  implements WebMvcConfigurer {
	
	// 이미지를 웹 링크로 접속가능하게 하기 위한 컨트롤러 webapp/images안에 있는 파일들을 localhost8081/images/~ 로 접속 가능하게 함
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:src/main/webapp/images/");
    }
}
