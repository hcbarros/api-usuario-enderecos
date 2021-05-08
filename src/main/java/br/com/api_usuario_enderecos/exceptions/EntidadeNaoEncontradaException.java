package br.com.api_usuario_enderecos.exceptions;

import javax.persistence.EntityNotFoundException;

public class EntidadeNaoEncontradaException extends EntityNotFoundException {

	public EntidadeNaoEncontradaException() {
		super("Entidade não encontrada!");
	}
}
