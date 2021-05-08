package br.com.api_usuario_enderecos.controller.response;

import java.util.Arrays;
import java.util.List;

public class ResponseError {
	
	private List<String> erros;
	private  String erro;
	
	public ResponseError(List<String> erros) {
		super();
		this.erros = erros;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
}