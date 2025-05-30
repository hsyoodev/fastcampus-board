package com.fastcampus.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastcampusBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastcampusBoardApplication.class, args);
    }

}
