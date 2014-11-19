package br.edu.tads.diariodeclasse;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void Disciplinas(View componente){
    	
    	Intent intentNovaTela = new Intent(MainActivity.this, CadastroDisciplina.class);
    	
    	MainActivity.this.startActivity(intentNovaTela);
    	
    	Button bt = (Button) findViewById(R.id.btnCadastroAluno);
    	
   	
    }
    
public void Alunos(View componente){
    	
    	Intent intentNovaTela = new Intent(MainActivity.this, AdicionarAluno.class);
    	MainActivity.this.startActivity(intentNovaTela);
    }
    
}
