package com.hyj.projectlibrary2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjectLibrary2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectLibrary2Application.class, args);
    }

}
