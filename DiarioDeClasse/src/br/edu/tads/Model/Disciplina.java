package br.edu.tads.Model;

public class Disciplina {

	// Variaveis
	private Long id;
	private String nome;
	private int cargaHoraria;
	private int ativo;

	// Construtor
	public Disciplina() {
		super();
		this.ativo = 1;
	}

	// Getters e Setters
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	// toString
	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}
}
