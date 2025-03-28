package carlosvinicios.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenApiConfig {
		
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
			.info(new Info()
			.title("API Teste Técnico Eteg")
			.version("v1")
			.description("API desenvolvida para prover os serviços de cadastros de usuários")
			.license(new License().name("Apache 2.0").url("https://github")));
	}	
	
}
