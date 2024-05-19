package com.ssafy.backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.backend.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan(basePackages = "com.ssafy.backend.domain.*.mapper")
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{
	private final AuthInterceptor authInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 검증된 사용자만 boards?
		registry
		.addInterceptor(authInterceptor)
		.addPathPatterns("/member/**");
	}

	// ws에서 들어오는 요청을 허용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/auth/**")
				.allowedOrigins("http://localhost:5173", "http://192.168.205.63:5173")
				.allowedMethods("POST");

		registry.addMapping("/member/**")
				.allowedOrigins("http://localhost:5173", "http://192.168.205.63:5173")
				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS");

		registry.addMapping("/map/**")
				.allowedOrigins("http://localhost:5173", "http://192.168.205.63:5173")
				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS");

		registry.addMapping("/plan/**")
				.allowedOrigins("http://localhost:5173", "http://192.168.205.63:5173")
				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
	}
}
