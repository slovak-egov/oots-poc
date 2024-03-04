package sk.mirri.ootsevidencefinder;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(apiInfoMetaData());

    }

    private Info apiInfoMetaData() {

        return new Info().title("OOTS EVIDENCE FINDER").description(
                "Umožňuje vyhľadávať procedúry, požiadavky, typy dôkazov a poskytovateľov registrovaných pre členské krajiny európskej únie.");
    }

}