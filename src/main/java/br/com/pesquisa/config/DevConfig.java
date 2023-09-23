package br.com.pesquisa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public void instaciaBaseDeDados() {
		this.dbService.instaciaBaseDeDados();
	}
}
