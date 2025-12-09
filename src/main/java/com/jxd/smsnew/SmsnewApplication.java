package com.jxd.smsnew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jxd.smsnew.dao")
public class SmsnewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsnewApplication.class, args);
    }

}
