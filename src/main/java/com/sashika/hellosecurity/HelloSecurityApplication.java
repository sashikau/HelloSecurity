package com.sashika.hellosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class HelloSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSecurityApplication.class, args);
    }

}
