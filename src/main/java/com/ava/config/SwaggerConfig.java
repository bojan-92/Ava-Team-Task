package com.ava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String TAG = "user-controller";

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ava.controller"))
				.paths(regex("/user.*"))
				.build()
				.apiInfo(metaData())
				.tags(new Tag(TAG, "Operations pertaining to users management"));
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for User Management Service",
				"1.0",
				"Terms of service",
				new Contact("Bojan Trifkovic", "https://github.com/bojan12345/Ava-Team-Task", "bojantrifkovic92@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");

		return apiInfo;
	}
}
