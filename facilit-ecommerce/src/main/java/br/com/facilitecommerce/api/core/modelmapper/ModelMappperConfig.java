package br.com.facilitecommerce.api.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
