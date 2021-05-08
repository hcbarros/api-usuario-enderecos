package br.com.api_usuario_enderecos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiUsuarioEnderecosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuarioEnderecosApplication.class, args);
	}

}
