package com.woophee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@PropertySource(value="classpath:woophee-data-transfer.properties")
public class DataTransferApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataTransferApplication.class, args);
    }
}
