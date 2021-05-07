package br.com.api_usuario_enderecos.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_usuario_enderecos.exceptions.CpfExistenteException;
import br.com.api_usuario_enderecos.exceptions.EmailExistenteException;
import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.repository.UsuarioRepositorio;


@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio repo;
	
	
	public Usuario salvar(Usuario usuario) {
		
		if(repo.existsByCpf(usuario.getCpf())) {
			throw new CpfExistenteException();
		}
		if(repo.existsByEmail(usuario.getEmail())) {
			throw new EmailExistenteException();
		}
		
		return repo.save(usuario);
	}	
	
	public Usuario buscarPorId(Long id) {
		return repo.findById(id)
				   .orElseThrow(() -> new EntityNotFoundException());
	}

}
