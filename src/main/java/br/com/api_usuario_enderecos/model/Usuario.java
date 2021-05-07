package br.com.api_usuario_enderecos.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull(message = "O nome não deve ser nulo!")
	@NotBlank(message = "O nome não deve estar em branco!")
	@Size(max = 100, message = "O nome deve possuir no máximo 100 caracteres!")
	private String nome;
	
	@Pattern(regexp="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
			message = "Email inválido!")
	@NotNull(message = "Informe um email!")
	@Size(max = 100, message = "O email deve possuir no máximo 100 caracteres!")
	private String email;
	
	@CPF(message = "CPF invalido!")
	@NotNull(message = "Informe um CPF!")
	private String cpf;
	
	@PastOrPresent(message = "Informe uma data atual ou do passado!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) //iso = DateTimeFormat.ISO.DATE
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Informe a data de nascimento!")
	private LocalDate data_nasc;
	
		
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, String cpf, LocalDate data_nasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

}