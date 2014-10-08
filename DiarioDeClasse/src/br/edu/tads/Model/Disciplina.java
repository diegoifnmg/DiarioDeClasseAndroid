package br.edu.tads.Model;

public class Disciplina {

	// Variaveis
	private long id;
	private String nome;
	private int cargaHoraria;
	private int ativo;
	private Aluno aluno;

	// Getters e Setters
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

	

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	// toString
	@Override
	public String toString() {
		return "Nome: " + this.nome;
	}
}
