package com.vincent.evaluating_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestHeader;


@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class EvaluatingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvaluatingSystemApplication.class, args);
    }

}
