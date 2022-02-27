package cybersoft.javabackend.moviejava14.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
	
	@Value("${openapi.info.title}") String infoTitle;
	@Value("${openapi.info.description}") String infoDescription;
	@Value("${openapi.info.version}") String infoVersion;
	
	@Value("${openapi.externalDocs.description}") String externalDocsDescription;
	@Value("${openapi.externalDocs.url}") String externalDocsUrl;
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
        .info(new Info().title(infoTitle)
	        .description(infoDescription)
	        .version(infoVersion))

        .externalDocs(new ExternalDocumentation()
	        .description(externalDocsDescription)
	        .url(externalDocsUrl));
	}
}
