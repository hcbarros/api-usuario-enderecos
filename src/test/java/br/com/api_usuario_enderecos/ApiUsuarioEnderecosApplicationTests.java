package br.com.api_usuario_enderecos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.api_usuario_enderecos.model.Endereco;
import br.com.api_usuario_enderecos.model.Usuario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiUsuarioEnderecosApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	

	@Test
	@Order(1)
	public void deveRetornarStatus200EUmaListadeEnderecos() {
	
		ResponseEntity<Usuario> resp = this.restTemplate
				.getForEntity("http://localhost:" + port + "/api/usuario/1", Usuario.class);
	
		assertEquals(resp.getStatusCodeValue(), 200);
		assertEquals(resp.getBody().getEnderecos().size(), 2);
	}
	
	@Test
	@Order(2)
	public void deveRetornarUsuarioNaoEncontrado() {
	
		ResponseEntity<String> resp = this.restTemplate
				.getForEntity("http://localhost:" + port + "/api/usuario/5", String.class);
	
		assertEquals(resp.getBody(), "Usuário não encontrado!");
	}
	
	@Test
	@Order(3)
	public void deveSalvarUsuario() {
	
		LocalDate localDate = LocalDate.parse("1995-01-10");
		Usuario usuario = new Usuario("Francisco da Silva", "francisco@gmail.com", "001.930.040-97", localDate);
		
		Usuario usuarioResponse = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/usuario", usuario, Usuario.class).getBody();
		
		ResponseEntity<Usuario> resp = this.restTemplate
				.getForEntity("http://localhost:" + port + "/api/usuario/"+usuarioResponse.getUsuario_id(), Usuario.class);
	
		assertEquals(resp.getBody().getCpf(), "001.930.040-97");
	}
	
	@Test
	@Order(4)
	public void deveSalvarEndereco() {
	
		Usuario usuario = this.restTemplate
				.getForEntity("http://localhost:" + port + "/api/usuario/1", Usuario.class).getBody();
		
		Endereco enderecoAntes = new Endereco("Rua das Graças", 377, "Apt 101", 
				  "Graças", "Recife", "PE", "52011-200", usuario);
		
		Endereco enderecoDepois = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/endereco", 
						enderecoAntes, Endereco.class).getBody();
	
		assertNotEquals(enderecoAntes.getId(), 
						enderecoDepois.getId());
	}

}
