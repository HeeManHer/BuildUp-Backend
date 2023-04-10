package com.warmmingup.buildup.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.warmmingup.buildup",annotationClass = Mapper.class)
public class MybatisConfiguration {}
