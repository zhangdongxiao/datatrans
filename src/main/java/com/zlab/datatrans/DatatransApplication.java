package com.zlab.datatrans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zlab")
public class DatatransApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatransApplication.class, args);
    }

}
