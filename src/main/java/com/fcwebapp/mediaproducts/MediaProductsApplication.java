package com.fcwebapp.mediaproducts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Media product REST API",
        description = "Media Product REST API for the Media Shop",
        version = "1.0",
        contact = @Contact(name = "Francis Chigozie",
        email = "cyriacus1210@gmail.com",
        url = "https://franciswebapp.com"),
        license = @License(
                name = "Apache 2.0"
        ))
)
public class MediaProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaProductsApplication.class, args);
    }

}
