package br.com.api_usuario_enderecos.exceptions;

public class EmailExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailExistenteException() {
		super("O email informado já existe!");
	}
}
