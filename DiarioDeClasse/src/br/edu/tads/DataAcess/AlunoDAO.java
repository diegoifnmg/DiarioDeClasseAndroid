package br.edu.tads.DataAcess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import br.edu.tads.Model.Aluno;

public class AlunoDAO {

	private static final String TABELA = "Aluno";
	private static final String TAG = "CADASTRO_ALUNO";
	private Context context;

	// Construtor.....................................................
	public AlunoDAO(Context context) {
		this.context = context;
	}

	// Cadastrar aluno................................................
	public void inserir(Aluno aluno) {
		// Objeto para armazenar os valores dos campos
		ContentValues values = new ContentValues();

		// Defini��o dos valores dos campos da tabela
		values.put("nome", aluno.getNome());
		values.put("email", aluno.getEmail());
		values.put("ativo", aluno.getAtivo());

		// Inser��o dos dados na tabela Projeto
		BDUtil bdUtil = new BDUtil(context);
		bdUtil.getWritableDatabase().insert(TABELA, null, values);
	}

	// Deletar Aluno...................................................
	public void deletar(Aluno aluno) {
		// Defini��o do Array de Parametros
		String[] args = { aluno.getId().toString() };

		// Exclus�o do Projeto
		BDUtil bdUtil = new BDUtil(context);
		bdUtil.getWritableDatabase().delete(TABELA, "id=?", args);
	}

	// Listar todos os alunos..........................................
	public List<Aluno> listar() {

		// Defini��o da Cole��o de Projetos
		List<Aluno> lista = new ArrayList<Aluno>();

		// Defini��o da Instru��o SQL
		String sql = "Select * from Aluno order by nome";

		// Objeto que recebe os registros do banco de dados
		BDUtil bdUtil = new BDUtil(context);
		Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);

		try {
			while (cursor.moveToNext()) {

				Aluno aluno = new Aluno();

				aluno.setId(cursor.getLong(0));
				aluno.setNome(cursor.getString(1));
				aluno.setEmail(cursor.getString(2));
				aluno.setAtivo(cursor.getInt(3));

				lista.add(aluno);
			}
		} catch (SQLException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			cursor.close();
		}
		return lista;
	}

	// Abrir um aluno passando o id como parametro....................
	public Aluno abrirAluno(Long id) {
		Aluno aluno = new Aluno();

		// Defini��o da Instru��o SQL
		String sql = "Select * from Aluno where CODIGO=";
		sql = sql + id.toString();

		// Objeto que recebe os registros do banco de dados
		BDUtil bdUtil = new BDUtil(context);
		Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);
		
		try {
			while (cursor.moveToNext()) {
				
				aluno.setId(cursor.getLong(0));
				aluno.setNome(cursor.getString(1));
				aluno.setEmail(cursor.getString(2));
				aluno.setAtivo(cursor.getInt(3));
			}
		} catch (SQLException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			cursor.close();
		}
		
		return aluno;		
	}

}
