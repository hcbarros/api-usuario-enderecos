package br.com.api_usuario_enderecos.controller;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api_usuario_enderecos.model.Endereco;
import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.service.ApiServico;
import br.com.api_usuario_enderecos.service.CepServico;


@RestController
@Validated
@RequestMapping("/api")
public class ApiController  {

	@Autowired
	private ApiServico servico;
	
	@Autowired
    private CepServico cepServico;
	
	
	@GetMapping(value = "/usuario/{id}")
	public Usuario buscarUsuario(@PathVariable Long id) {
		return servico.buscarPorId(id);		
	}
	
	@GetMapping("/cep/{cep}")
    public Endereco getCep(@PathVariable String cep, 
    					   @RequestBody Endereco body) {

        Endereco viaCEP = cepServico.buscaEnderecoPorCep(cep);
        
        return servico.salvarEnderecoViaCEP(viaCEP, body); 
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

