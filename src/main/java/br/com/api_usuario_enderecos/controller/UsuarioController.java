package br.com.api_usuario_enderecos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_usuario_enderecos.model.Endereco;
import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.service.ApiServico;


@RestController
@Validated
@RequestMapping("/api")
public class UsuarioController  {

	@Autowired
	private ApiServico servico;
	
	
	@GetMapping(value = "/usuario/{id}")
	public Usuario buscarUsuario(@PathVariable Long id) {
		return servico.buscarPorId(id);		
	}
	
	@PostMapping(value = "/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvarUsuario(@RequestBody @Valid Usuario usuario) {
		return servico.salvarUsuario(usuario);
	}
	
	@PostMapping(value = "/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salvarEndereco(@RequestBody @Valid Endereco endereco) {
		return servico.salvarEndereco(endereco);
	}
		
}

