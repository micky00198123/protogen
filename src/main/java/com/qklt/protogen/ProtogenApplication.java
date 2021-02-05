package com.qklt.protogen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qklt.protogen.mapper")
public class ProtogenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtogenApplication.class, args);
    }

}
