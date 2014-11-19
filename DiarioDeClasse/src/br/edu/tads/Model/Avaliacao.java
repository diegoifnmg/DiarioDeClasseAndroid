package br.edu.tads.Model;

public class Avaliacao {
	
	private long id;
	private float valor;
	private int ativo;
	private Disciplina disciplina;
	private String nome;
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
	  if (valor>0)
		this.valor = valor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
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
