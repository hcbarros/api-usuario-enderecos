package br.com.api_usuario_enderecos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api_usuario_enderecos.model.Endereco;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepServico {

    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
}	