package br.com.api_usuario_enderecos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull(message = "Informe um email!")
	private String logradouro;
	
	@NotNull(message = "Informe o número da residência!")
	private Integer numero;
	
	private String complemento;
	
	@NotNull(message = "Informe um bairro!")
	private String bairro;
	
	@NotNull(message = "Informe a cidade!")
	private String localidade;
	
	@NotNull(message = "Informe o Estado!")
	private String uf;
	
	@NotNull(message = "Informe o CEP!")
	private String cep;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
	
	
	public Endereco() {
		
	}

	public Endereco(String logradouro, Integer numero, String complemento, 
					String bairro, String localidade, String uf, 
					String cep, Usuario usuario) {

		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getLocalidade() {
		return localidade;
	}


	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
