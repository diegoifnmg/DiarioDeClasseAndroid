package Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDUtil extends SQLiteOpenHelper{
	
	private static final  String NOME_BD="BD_DIARIO";
	private static final int VERSAO =1;
	
	private static final String TABELA_DISCIPLINA= "Disciplina";
	
			

	public BDUtil(Context context) {
		super(context, NOME_BD,null, VERSAO);
		// TODO Auto-generated constructor stub
		
		
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddlDisciplina = "CREATE TABLE"+ TABELA_DISCIPLINA +
				               "(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT," +
				               "NOME TEXT,CARGA_HORARIA INTEGER, ATIVO TEXT)";
		
		db.execSQL(ddlDisciplina);
			
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
