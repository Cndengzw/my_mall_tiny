package com.offerget.cndengzw.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.offerget.cndengzw.tiny.mbg.mapper")
public class MyBatisConfig {
}