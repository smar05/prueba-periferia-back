package com.example.periferiaback.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Periferia backend",
        version = "1.0.0",
        description = "Api rest para la prueba de periferia"
    )
)
public class OpenApiCOnfig {
        
}
