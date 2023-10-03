package com.edu;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.unit.DataSize;

import com.edu.config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class) 
public class EcomerceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceOneApplication.class, args);
	}
	
//	@Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        // Set the maximum file size you want to allow.
//        factory.setMaxFileSize(DataSize.ofMegabytes(10)); // Adjust this as needed.
//        // You can also configure other settings here.
//        return factory.createMultipartConfig();
//    }
}
