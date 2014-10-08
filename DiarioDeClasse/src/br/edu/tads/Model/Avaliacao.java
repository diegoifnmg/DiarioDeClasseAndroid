package br.edu.tads.Model;

public class Avaliacao {
	
	private long id;
	private int valor;
	private boolean ativo;
	private Disciplina disciplina;
	private String nome;
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
	  if (valor>0)
		this.valor = valor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	

}
