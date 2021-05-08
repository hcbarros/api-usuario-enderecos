package br.com.api_usuario_enderecos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api_usuario_enderecos.model.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long>  {

}
