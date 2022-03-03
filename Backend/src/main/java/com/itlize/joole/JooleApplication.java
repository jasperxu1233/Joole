package com.itlize.joole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JooleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooleApplication.class, args);
    }

}
