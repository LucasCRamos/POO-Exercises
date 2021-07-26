package br.usp.ime.mac321.ep2;

public class Usuario {
	
	private String nome;
	private String cpf;
	
	public Usuario(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

}
