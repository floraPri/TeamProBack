package com.np.wearound.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // 경로 주의
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.np.wearound.service.TokenBlacklistService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 경로 주의
public class SecurityConfig {
   
   private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
   private final UserAuthProvider userAuthProvider;
   private final TokenBlacklistService tokenBlacklistService;
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      
      System.out.println("=== SecurityConfig - securityFilterChain ===");
      http
      .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
      .and()
      .addFilterBefore(new JwtAuthFilter(userAuthProvider, tokenBlacklistService), BasicAuthenticationFilter.class) // Spring security의 인증필터 앞에 JWT 필터 추가
      .csrf().disable() // 복잡성을 피하기 위해 csrf를 비활성화 한다
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // stateless 애플리케이션을 스프링에게 전달하면 스프링에서 세션과 쿠키를 생성하지 않음
      .and()
      .authorizeHttpRequests((requests) -> requests
          .antMatchers("/login", "/register","/logout","/search/*","/images/**","/socket.io/**","/ws/**").permitAll() // 인증이 필요하지 않은 유일한 엔드포인트,리액트의 url과 일치시켜야 함
          //.antMatchers("/**").permitAll()
          .antMatchers("/auction/*","/myPage","/user/*","/funding/*").hasAnyRole("USER")//user만 진입가능
          .antMatchers("/admin/*").hasAnyRole("ADMIN")//admin만 진입가능
            .anyRequest().authenticated() // 나머지 엔드포인트는 인증을 받아야 함            
            );
      
      return http.build();
   }

}