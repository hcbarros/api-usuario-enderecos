package br.com.api_usuario_enderecos.exceptions;

public class CpfExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CpfExistenteException() {
		super("O CPF informado já existe!");
	}
}
