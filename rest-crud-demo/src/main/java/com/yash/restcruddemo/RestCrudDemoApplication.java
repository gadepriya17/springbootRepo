package com.yash.restcruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class RestCrudDemoApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RestCrudDemoApplication.class, args);
	}

//	@Bean
//	public Docket swaggerConfiguration()
//	{
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/cloudevendor/"))
//				.apis(RequestHandlerSelectors.basePackage("com.yash.restcruddemo"))
//				.build()
//				.apiInfo(apiCustomData());
//	}
//
//	private ApiInfo apiCustomData()
//	{
//		return new ApiInfo(
//				"Cloud Vendor API Application",
// 				"Cloud vendor documentation",
//				"2.0",
//				"cloud vendor service Terms",
//				new Contact("Priya Gade","http://www.yash.com","priya.gade@yash.com"),
//				"Yash Tech License",
//				"http://www.yash.com",
//				Collections.emptyList()
//				);
//	}
}