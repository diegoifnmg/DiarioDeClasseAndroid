package br.edu.tads.DataAcess;

import java.util.ArrayList;
import java.util.List;

import br.edu.tads.Model.Aluno;
import br.edu.tads.Model.Avaliacao;
import br.edu.tads.Model.Disciplina;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

public class AvaliacaoDAO {
	private Context context;
	private static final String TABELA = "Avaliacao";
	private static final String TAG = "AVALIACAO_DAO";
	
	// Construtor................................................................
	public AvaliacaoDAO(Context context) {
		this.context = context;
	}
	
	// M�todo Cadastrar..........................................................
	public void inserir(Avaliacao avaliacao) {
		
		ContentValues contentValues = new ContentValues();

		contentValues.put("nome", avaliacao.getNome());	
		contentValues.put("valor", avaliacao.getValor());		
		contentValues.put("ativo", avaliacao.getAtivo());
		contentValues.put("idDisciplina", avaliacao.getDisciplina().getId());

		BDUtil bdUtil = new BDUtil(this.context);
		bdUtil.getWritableDatabase().insert(TABELA, null, contentValues);
		bdUtil.close();
	}
	
	// Listar Avaliacoes.................................................
	public List<Avaliacao> listar() {

		
		List<Avaliacao> lista = new ArrayList<Avaliacao>();

		// Defini��o da Instru��o SQL
		String sql = "Select * from Avaliacao order by nome";

		// Objeto que recebe os registros do banco de dados
		BDUtil bdUtil = new BDUtil(context);
		Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);

		try {
			while (cursor.moveToNext()) {

				Avaliacao avaliacao = new Avaliacao();

				avaliacao.setId(cursor.getLong(0));
				avaliacao.setNome(cursor.getString(1));
				avaliacao.setAtivo(cursor.getInt(2));
				avaliacao.setValor(cursor.getFloat(3));
						
				
				
				lista.add(avaliacao);
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
