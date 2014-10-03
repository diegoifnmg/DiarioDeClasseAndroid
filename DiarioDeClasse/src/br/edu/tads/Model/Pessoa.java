package br.edu.tads.Model;

public class Pessoa {
	
	//Variaveis
	private long id;
	private String nome;
	private String email;
	private boolean ativo;
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	//toString
	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}
}
