package br.edu.tads.diariodeclasse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarAluno extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adicionar_aluno);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adicionar_aluno, menu);
		return true;
	}
	
	public void Adicionar(View componente){
		
		Intent intentNovaTela = new Intent(AdicionarAluno.this, MainActivity.class);
		
		
		
		
		
		
		
		
		
		Toast.makeText(AdicionarAluno.this,
				" Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
		
		
		
    	
    	AdicionarAluno.this.startActivity(intentNovaTela);
		
	}

}
