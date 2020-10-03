package com.jyh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

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
