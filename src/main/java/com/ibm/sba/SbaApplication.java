package com.ibm.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaApplication.class, args);
    }

}
