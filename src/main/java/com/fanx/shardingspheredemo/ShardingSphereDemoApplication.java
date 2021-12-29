package com.fanx.shardingspheredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class ShardingSphereDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereDemoApplication.class);
    }
}
