package br.edu.tads.DataAcess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import br.edu.tads.Model.Disciplina;

public class DisciplinaDAO {
	private Context context;
	private static final String TABELA = "Disciplina";
	private static final String TAG = "CADASTRO_DISCIPLINA";

	// Construtor.................................................
	public DisciplinaDAO(Context context) {
		this.context = context;
	}

	// Método Cadastrar...........................................
	public void Inserir(Disciplina disciplina) {
		BDUtil bdUtil = new BDUtil(this.context);
		ContentValues contentValues = new ContentValues();

		contentValues.put("nome", disciplina.getNome());
		contentValues.put("carga_horaria", disciplina.getCargaHoraria());
		contentValues.put("ativo", disciplina.getAtivo());
		contentValues.put("codAluno", 1);


		bdUtil.getWritableDatabase().insert("DISCIPLINA", null, contentValues);
	}

	// Método Apagar..............................................
	public void deletar(Disciplina disciplina) {
		String[] args = { disciplina.getId().toString() };

		// Exclusão da Disciplina
		BDUtil bdUtil = new BDUtil(context);
		bdUtil.getWritableDatabase().delete(TABELA, "id=?", args);
	}

	// Listar todos os alunos.....................................
	public List<Disciplina> listar() {

		// Definição da Coleção de Disciplinas
		List<Disciplina> lista = new ArrayList<Disciplina>();
		
		AlunoDAO alunoDAO = new AlunoDAO(this.context);

		// Definição da Instrução SQL
		String sql = "Select * from Disciplina";

		// Objeto que recebe os registros do banco de dados
		BDUtil bdUtil = new BDUtil(context);
		Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);

		try {
			while (cursor.moveToNext()) {

				Disciplina disciplina = new Disciplina();

				disciplina.setId(cursor.getLong(0));
				disciplina.setNome(cursor.getString(1));				
				disciplina.setCargaHoraria(cursor.getInt(2));
				disciplina.setAtivo(cursor.getInt(3));				
				disciplina.setAluno(alunoDAO.abrirAluno(cursor.getLong(4)));

				lista.add(disciplina);
			}
		} catch (SQLException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			cursor.close();
		}
		return lista;
	}

}
