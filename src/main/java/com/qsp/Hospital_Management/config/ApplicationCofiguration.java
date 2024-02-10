package com.qsp.Hospital_Management.config;
// Url For Swagger Documentation  ===> http://localhost:8080/swagger-ui.html#
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationCofiguration {

	@Bean
	public Docket getDocket() {
		//1. Contact Datails Name , url ,email
		Contact contact = new Contact("Qspider", "htteps://qspiders.com", "qspiders@gmail.com");
		
		//2. Yours Venders i.e previous customer
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		
		//3.API Info
	    ApiInfo apiInfo = new ApiInfo("Hospital Management System", "This App is Used to maintain and manage the deatils of the patient in an Hospital", "Version1.0", "1 year Of Free Service", contact, "QSP001", "http://qsp001.com", extensions);
	    
	    // Docket is class
	    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.qsp.Hospital_Management")).build().useDefaultResponseMessages(false);
	    
	}
}
