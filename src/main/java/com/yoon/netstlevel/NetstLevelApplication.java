package com.yoon.netstlevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NetstLevelApplication {
    public static void main(String[] args) {
        SpringApplication.run(NetstLevelApplication.class, args);
    }

}
