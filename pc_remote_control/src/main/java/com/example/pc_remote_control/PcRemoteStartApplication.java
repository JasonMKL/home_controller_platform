package com.example.pc_remote_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.example"})
public class PcRemoteStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcRemoteStartApplication.class, args);
    }

}
