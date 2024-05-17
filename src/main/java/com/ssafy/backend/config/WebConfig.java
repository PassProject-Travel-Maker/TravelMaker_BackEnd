package com.ssafy.backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan(basePackages = "com.ssafy.backend.domain.*.mapper")
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{

}
