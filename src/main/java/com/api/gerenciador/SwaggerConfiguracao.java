package com.api.gerenciador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfiguracao {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                .basePackage("com.api.gerenciador.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    /* retorna as informações da API */
    /* fica visível na API */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API - Gerenciamento Estudantil")
                .description("API de gerenciamento estudantil")
                .version("1.0")
                .termsOfServiceUrl("https://github.com/Luizbornia/StudentManager")
                .license("Luiz Giovanni Bornia")
                .build();
    }
}