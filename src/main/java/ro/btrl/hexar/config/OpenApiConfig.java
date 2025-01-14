package ro.btrl.hexar.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            var info = new Info();
            info.title("Hexar API");
            info.description("Public APIs for Hexar");
            info.version("1.0");
            openApi.setInfo(info);
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                apiResponses.addApiResponse("400", new ApiResponse().description("Bad Request"));
                apiResponses.addApiResponse("401", new ApiResponse().description("Unauthorized"));
                apiResponses.addApiResponse("403", new ApiResponse().description("Forbidden"));
                apiResponses.addApiResponse("404", new ApiResponse().description("Not Found"));
                apiResponses.addApiResponse("500", new ApiResponse().description("Internal Server Error"));
            }));
        };
    }
}
