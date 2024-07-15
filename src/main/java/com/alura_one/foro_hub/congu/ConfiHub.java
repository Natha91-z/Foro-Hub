package com.alura_one.foro_hub.congu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ConfiHub implements webMvcConfigurer{
    @Override
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping(" /").allowedOrigins("http://localhost:3306").allowedMethods("GET","POST","PUT","DELETE");
    }
}
