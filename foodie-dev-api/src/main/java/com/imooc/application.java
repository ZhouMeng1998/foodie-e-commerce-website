package com.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;
import org.apache.log4j.Logger;

import java.util.logging.LogManager;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.imooc", "org.n3r.idworker"})
@MapperScan(basePackages = "com.imooc.mapper")
public class application {
    private static Logger logger = Logger.getLogger(application.class);
    public static void main(String[] args) {
        try {
            SpringApplication.run(application.class, args);
        } catch (Throwable e) {
            logger.error("failed", e);
        }
    }
}
