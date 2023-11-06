package com.np.wearound.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;//cors주의 - reactive(x)
import org.springframework.web.filter.CorsFilter; //주의
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {
	
	@Bean
	public FilterRegistrationBean corsFilter() {
		
		//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		//프론트엔드가 일부 자격증명을 보내면 그것들을 받아들여야 한다.
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowCredentials(true);
//		config.addAllowedOriginPattern("*");
		config.addAllowedOrigin("http://localhost:3000");
		config.setAllowedHeaders(Arrays.asList(
				HttpHeaders.AUTHORIZATION,
				HttpHeaders.CONTENT_TYPE,
				HttpHeaders.ACCEPT
				));
		config.setAllowedMethods(Arrays.asList(
				HttpMethod.GET.name(),
				HttpMethod.POST.name(),
				HttpMethod.PUT.name(),
				HttpMethod.DELETE.name()
				));
		
		config.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", config);	//Spring Security 필터전에 사용하기 위해 요청에 적용
		
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(-102); //가장 낮은 위치
		
		
		return bean;
		
//		CORS(Cross-Resource Sharing : 교차 출처 자원 공유)
//		백엔드는 프런트엔드에서 오는 요청을 신뢰하지 않는다.
//		기본적으로 백엔드는 자신에게서 오는 요청만 수락하낟.
//		따라서 프런트엔드의 요청을 수락하도록 백엔드를 구성해야 한다.(Cors Policy에 의해 Not Access 해결)
	}

}
