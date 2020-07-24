package com.lujieni.springbootguavacache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.**.dao")
public class SpringbootGuavaCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGuavaCacheApplication.class, args);
    }

}
