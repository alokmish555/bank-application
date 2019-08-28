package com.demo.bankapp.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .groupName("accounts-service")
            .useDefaultResponseMessages(false)
            .select().paths(regex("/api/.*"))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("accounts-service API")
            .description("accounts-service API reference for developers")
            .version("0.0.1")
            .license("N/A")
            .build();
    }
}
