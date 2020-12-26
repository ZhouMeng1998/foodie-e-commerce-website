package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/hello")
    public Object Hello() {
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
        return "Hello";
    }

}
