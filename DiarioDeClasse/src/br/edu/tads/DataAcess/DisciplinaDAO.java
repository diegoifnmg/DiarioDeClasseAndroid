package br.edu.tads.DataAcess;


import android.content.ContentValues;
import android.content.Context;

public class DisciplinaDAO {
private Context context;


	public DisciplinaDAO(Context context){
		this.context= context;
	}
	
	public void Inserir (Disciplina disciplina){
		BDUtil bdUtil= new BDUtil(this.context);
		 ContentValues contentValues = new ContentValues();
		 		 
		 
		 contentValues.put("NOME",disciplina.getNome());
		 contentValues.put("CARGA_HORARIA",disciplina.getCargaHoraria());
		 contentValues.put("ATIVO",disciplina.getAtivo());
		 
		 bdUtil.getWritableDatabase().insert("DISCIPLINA", null, contentValues);
		 
		
		
	}

}
