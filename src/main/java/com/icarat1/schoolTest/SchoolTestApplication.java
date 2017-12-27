package com.icarat1.schoolTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy
public class SchoolTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolTestApplication.class, args);
	}


@Bean
public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
			.pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false);
}

/**
 * swagger apiInfo conFiguration
 *
 * @return ApiInfoBuilder
 * 
 */

@Bean
public ApiInfo apiInfo() {
	final ApiInfoBuilder builder = new ApiInfoBuilder();
	builder.title("TRY Rest Api").version("1.0").license(" Copyright ")
			.description("The API provides a platform to manage Try App");
	return builder.build();
}
}
