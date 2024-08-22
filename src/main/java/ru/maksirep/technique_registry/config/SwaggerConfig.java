package ru.maksirep.technique_registry.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "Регистр техники";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title(TITLE));
    }
}
