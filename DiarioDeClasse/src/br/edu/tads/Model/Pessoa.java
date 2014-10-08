package br.edu.tads.Model;

public class Pessoa {
	
	//Variaveis
	private Long id;
	private String nome;
	private String email;
	private int ativo;
	
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	//toString
	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}
}
