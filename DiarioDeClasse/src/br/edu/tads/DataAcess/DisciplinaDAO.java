package br.edu.tads.DataAcess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import br.edu.tads.Model.Aluno;
import br.edu.tads.Model.Disciplina;

public class DisciplinaDAO {
	private Context context;
	private static final String TABELA = "Disciplina";
	private static final String TAG = "DISCIPLINA_DAO";

	// Construtor................................................................
	public DisciplinaDAO(Context context) {
		this.context = context;
	}

	// Método Cadastrar..........................................................
	public void inserir(Disciplina disciplina) {
		
		ContentValues contentValues = new ContentValues();

		contentValues.put("nome", disciplina.getNome());
		contentValues.put("carga_horaria", disciplina.getCargaHoraria());
		contentValues.put("ativo", disciplina.getAtivo());

		BDUtil bdUtil = new BDUtil(this.context);
		bdUtil.getWritableDatabase().insert(TABELA, null, contentValues);
		bdUtil.close();
	}

	// Método Apagar....................................................................
	public void deletar(Disciplina disciplina) {
		String[] args = { disciplina.getId().toString() };

		AlunoDAO alunoDAO = new AlunoDAO(this.context);
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		alunos = alunoDAO.listarAlunosDisciplina(disciplina.getId());		
		
		if(!alunos.isEmpty()){
			for(Aluno a : alunos){
				alunoDAO.deletar(a);
			}
		}
		
		// Exclusão da Disciplina
		BDUtil bdUtil = new BDUtil(context);
		bdUtil.getWritableDatabase().delete(TABELA, "id=?", args);
		bdUtil.close();
	}

	// Listar todos os alunos...........................................................
	public List<Disciplina> listar() {

		// Definição da Coleção de Disciplinas
		List<Disciplina> lista = new ArrayList<Disciplina>();

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

				lista.add(disciplina);
			}
		} catch (SQLException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			cursor.close();
			bdUtil.close();
		}
		return lista;
	}

}
