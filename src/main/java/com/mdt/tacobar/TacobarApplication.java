package com.mdt.tacobar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacobarApplication {

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.traverse();

        SpringApplication.run(TacobarApplication.class, args);
    }

}
