package com.xlab.datatrans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xlab")
public class DatatransApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatransApplication.class, args);
    }

}
