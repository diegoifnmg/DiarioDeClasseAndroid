package br.edu.tads.Model;

public class Disiciplina {
	
	//Variaveis
	private long id;
	private String nome;
	private int cargaHoraria;
	private boolean ativo;
	
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
