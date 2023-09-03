package model;

import java.sql.Date;

public class Cliente {

	private String cpf;
	private String nome;
	private String email;
	private float limiteDeCredito;
	private Date dataNascimento;
	
	
	public Cliente(String cpf, String nome, String email, float limiteCredito, Date dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.limiteDeCredito = limiteCredito;
		this.dataNascimento = dataNasc;
	}
	
	public Cliente() {
		
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}
	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
