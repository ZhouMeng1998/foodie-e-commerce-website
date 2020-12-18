package com.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@EnableTransactionManagement
@MapperScan(basePackages = "com.imooc.mapper")
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
