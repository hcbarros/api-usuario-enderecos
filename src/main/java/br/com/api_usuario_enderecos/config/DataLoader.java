package br.com.api_usuario_enderecos.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.repository.UsuarioRepositorio;


@Configuration
@Profile("prod")
public class DataLoader {
	
	
	@Bean
	CommandLineRunner baseLoad(UsuarioRepositorio repo) {
		 
		return args -> {
			
			LocalDate l = LocalDate.parse("1976-10-27");
			
			Usuario usuario = new Usuario("Henrique", "henrique@gmail.com", "026.572.264-00", l);
			
			repo.save(usuario);
		};
	}

}