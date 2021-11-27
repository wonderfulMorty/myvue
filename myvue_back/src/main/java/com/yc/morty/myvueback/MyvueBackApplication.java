package com.yc.morty.myvueback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.morty.myvueback.mapper")
public class MyvueBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyvueBackApplication.class, args);
    }

}
