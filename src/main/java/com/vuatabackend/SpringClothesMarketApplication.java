package com.vuatabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "com.pedroprojects.repository")
public class SpringClothesMarketApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringClothesMarketApplication.class, args);
    }
}
