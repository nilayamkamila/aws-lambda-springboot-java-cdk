package org.example.aws.lambda.springboot;

import org.example.aws.lambda.springboot.controller.LambdaRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class SpringBootLambdaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLambdaApplication.class, args);
    }
}
