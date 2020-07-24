package com.lujieni.springbootguavacache.config;

import com.lujieni.springbootguavacache.cache.guava.student.StudentGuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public StudentGuavaCache studentGuavaCache(){
        return new StudentGuavaCache();
    }


}