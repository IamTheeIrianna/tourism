package com.example.tourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class  TouristGuideAPI {

    public static void main(String[] args) {
        String test = System.getenv("PROD_DATABASE_URL");
        System.out.println(test);
        SpringApplication.run(TouristGuideAPI.class, args);
    }

}
