package com.warmmingup.buildup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    private ApiInfo swaggerInfo () {
        return new ApiInfoBuilder().title("Greedy API").description("spring boot swagger 연동 테스트").build();
    }

    @Bean
    public Docket swaggerApi () {
        return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes()).apiInfo(swaggerInfo()).select().apis(RequestHandlerSelectors.basePackage("com.warmmingup.buildup")).paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
    }

    private Set<String> getConsumeContentTypes () {
        Set<String> consume = new HashSet<>();
        consume.add("application/json;charset=UTF-8");
        consume.add("application/x-www-form-urlencoded");
        return consume;
    }

    private Set<String> getProduceContentTypes () {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");

        return produces;
    }
}
