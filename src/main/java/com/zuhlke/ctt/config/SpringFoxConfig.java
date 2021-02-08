package com.zuhlke.ctt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * configuration class to config different parts of swagger
 * @author paria
 */
@Configuration
@Import({SpringDataRestConfiguration.class ,BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfig {


    /**
     * After defining the Docket bean, its select() method returns an instance of ApiSelectorBuilder,
     * which provides a way to control the endpoints exposed by Swagger. We can configure predicates
     * for selecting RequestHandlers with the help of RequestHandlerSelectors and PathSelectors.
     * Using any() for both will make documentation for our entire API available through Swagger.
     * to check if swagger is working or not follow bellow link after running the app
     * <a>http://localhost:8080/uour-app-root/api/v2/api-docs</a>
     * <a>http://localhost:8080/v2/api-docs</a>
     * <a>http://localhost:8080/swagger-ui/#/</a>
     * @return
     */

    //TODO what is a Docket?
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Calculator Test Tool Application Rest API ",
                "this application is a prototype to check the feasiblity for creating a Test Application to test Calculator Middle Ware application By Zühlke ",
                "CTT prototype",
                null,
                new Contact("Paria Hosseiny", "https://github.com/pariaSadatHosseiny/Calculator-Test-Tool", "p.hosseiny72@gmail.com"),
                "No license", null, Collections.emptyList());
    }
}
