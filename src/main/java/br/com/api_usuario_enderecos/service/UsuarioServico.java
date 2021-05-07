package br.com.api_usuario_enderecos.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api_usuario_enderecos.model.Usuario;
import br.com.api_usuario_enderecos.repository.UsuarioRepositorio;


@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio repo;
	
	
	public Usuario salvar(Usuario estudante) {
		return repo.save(estudante);
	}	
	
	public Usuario buscarPorId(Long id) {
		return repo.findById(id)
				   .orElseThrow(() -> new EntityNotFoundException());
	}

}
