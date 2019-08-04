package com.jyh;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jyh
 * @date 2019/4/10
 */

@SpringBootApplication
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class,args);
    }

}
