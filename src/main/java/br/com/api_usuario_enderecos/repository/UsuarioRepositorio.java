package br.com.api_usuario_enderecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api_usuario_enderecos.model.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {

}
