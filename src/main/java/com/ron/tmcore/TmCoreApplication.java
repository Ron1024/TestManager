package com.ron.tmcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@MapperScan(value = "com.ron.tmcore.mapper")
public class TmCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmCoreApplication.class, args);
    }
}
