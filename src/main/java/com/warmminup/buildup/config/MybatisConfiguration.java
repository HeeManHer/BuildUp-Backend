package com.warmminup.buildup.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.warmminup.buildup",annotationClass = Mapper.class)
public class MybatisConfiguration {}
