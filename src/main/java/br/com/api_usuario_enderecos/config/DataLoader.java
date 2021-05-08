package br.com.api_usuario_enderecos.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api_usuario_enderecos.model.Endereco;
import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.repository.EnderecoRepositorio;
import br.com.api_usuario_enderecos.repository.UsuarioRepositorio;


@Configuration
@Profile("prod")
public class DataLoader {
	
	
	@Bean
	CommandLineRunner baseLoad(UsuarioRepositorio repoUsuario, 
							   EnderecoRepositorio repoEndereco) {
		 
		return args -> {
			
			LocalDate localDate = LocalDate.parse("2000-10-10");
			
			Usuario usuario = new Usuario("Jose da Silva", "jose@gmail.com", "532.052.520-63", localDate);
			
			Usuario usuarioSalvo = repoUsuario.save(usuario);
	
	
			
			Endereco endereco1 = new Endereco("Rua da Hora", 473, "Bloco A", 
											  "Espinheiro", "Recife", "PE", "52020-015", usuarioSalvo);
			
			Endereco endereco2 = new Endereco("Rua da Praia", 153, "5o andar", 
					  						  "São José", "Recife", "PE", "50020-550", usuarioSalvo);
			
			repoEndereco.saveAll(Arrays.asList(endereco1, endereco2));
		};
	}

}