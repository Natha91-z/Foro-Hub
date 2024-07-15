package com.alura_one.foro_hub.congu;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public interface webMvcConfigurer {
    void addCorsMapping(CorsRegistry registry);
}
