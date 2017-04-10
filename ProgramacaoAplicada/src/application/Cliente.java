package application;

import java.time.LocalDate;

public class Cliente {
	
	private String nome;
	private String cpf;
	private LocalDate data_nascimento;
	
	public Cliente(){
	}
	
	public Cliente(String nome, String cpf, LocalDate data) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	// sobrescreve o meteodo to string do objeto fazendo com que seja impresso o nome e cpf no lugar do pacote da classe
	@Override
	public String toString(){
		return nome + " " + cpf;
	}
	
}
