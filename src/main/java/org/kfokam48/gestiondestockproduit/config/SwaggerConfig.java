package org.kfokam48.gestiondestockproduit.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(" STOCK MANAGEMENT API")
                        .description("APIs pour gérer les produits, incluant la création, mise à jour et suppression et le contrôle de la quantité en stock")
                        .version("1.0.0")
                );
    }
}

