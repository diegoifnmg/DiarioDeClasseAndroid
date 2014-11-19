package br.edu.tads.DataAcess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {

	private static final String NOME_BD = "BD_DIARIO";
	private static final int VERSAO = 1;

	private static final String TABELA_DISCIPLINA = "Disciplina";
	private static final String TABELA_AVALIACAO = "Avaliacao";
	private static final String TABELA_ALUNO = "Aluno";

	// Construtor.........................................................
	public BDUtil(Context context) {
		super(context, NOME_BD, null, VERSAO);
		// TODO Auto-generated constructor stub
	}

	// onCreate...........................................................
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String ddlAluno = "CREATE TABLE " + TABELA_ALUNO
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT, "
				+ "email TEXT, "
				+ "ativo INTEGER, "
				+ "idDisciplina INTEGER"
				+ "FOREIGN KEY (idDisciplina) REFERENCES Disciplina(codigo)"
				+ " )";
		
		String ddlDisciplina = "CREATE TABLE " + TABELA_DISCIPLINA
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT, "
				+ "carga_horaria INTEGER, "
				+ "ativo INTEGER "
				+ ")";
		
		String ddlAvaliacao = "CREATE TABLE " + TABELA_AVALIACAO
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT, "
				+ "ativo INTEGER, "
				+ "valor_total FLOAT"
				+ "idDisciplina INTEGER"
				+ "FOREIGN KEY (idDisciplina) REFERENCES Disciplina(codigo)"
				+ " )";

		
		db.execSQL(ddlAluno);
		db.execSQL(ddlDisciplina);
		db.execSQL(ddlAvaliacao);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
