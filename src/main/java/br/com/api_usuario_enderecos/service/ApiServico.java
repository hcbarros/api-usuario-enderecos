package br.com.api_usuario_enderecos.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_usuario_enderecos.exceptions.CpfExistenteException;
import br.com.api_usuario_enderecos.exceptions.EmailExistenteException;
import br.com.api_usuario_enderecos.model.Endereco;
import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.repository.EnderecoRepositorio;
import br.com.api_usuario_enderecos.repository.UsuarioRepositorio;


@Service
public class ApiServico {
	
	@Autowired
	private UsuarioRepositorio repoUsuario;
	
	@Autowired
	private EnderecoRepositorio repoEndereco;
	
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		if(repoUsuario.existsByCpf(usuario.getCpf())) {
			throw new CpfExistenteException();
		}
		if(repoUsuario.existsByEmail(usuario.getEmail())) {
			throw new EmailExistenteException();
		}
		
		return repoUsuario.save(usuario);
	}	
	
	public Endereco salvarEndereco(Endereco endereco) {
		return repoEndereco.save(endereco);
	}	
	
	public Endereco salvarEnderecoViaCEP(Endereco viaCEP, Endereco body) {
		
		if(viaCEP != null) {
        	if(viaCEP.getCep() == null) 
        		throw new EntityNotFoundException("CEP não encontrado!");
        	
        	body.setLogradouro(viaCEP.getLogradouro());
        	body.setBairro(viaCEP.getBairro());
        	body.setLocalidade(viaCEP.getLocalidade());
        	body.setUf(viaCEP.getUf());
        	body.setCep(viaCEP.getCep());
        }
		
		return repoEndereco.save(body);
	}	
	
	public Usuario buscarPorId(Long id) {
		return repoUsuario.findById(id)
				   .orElseThrow(() -> 
				   new EntityNotFoundException("Usuário não encontrado!"));
	}

}
