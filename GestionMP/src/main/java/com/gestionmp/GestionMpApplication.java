package com.gestionmp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.gestionmp.entities.Patient;

@SpringBootApplication
public class GestionMpApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionMpApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Patient.class);
	}
}
