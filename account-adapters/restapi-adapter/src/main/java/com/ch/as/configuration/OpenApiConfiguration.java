package com.ch.as.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author iBrahim chniti
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    @Profile("!prod")
    public OpenAPI accountOpenPI() {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title("Acccount Service API")
                                .version("v1.0.0")
                                .description("This service serves as demo project for bank account deposit and withdrawal transactions"));
    }
}
