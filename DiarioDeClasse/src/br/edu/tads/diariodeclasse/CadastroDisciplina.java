package br.edu.tads.diariodeclasse;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.edu.tads.DataAcess.DisciplinaDAO;
import br.edu.tads.Model.Disciplina;

public class CadastroDisciplina extends Activity {

	
	private static Long ID_DISCIPLINA = (long) 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_disciplina);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro_disciplina, menu);
		return true;
	}
	 
	public void Adicionar(View componente){
		
		EditText edtNome = (EditText)this.findViewById(R.id.edtNome);
		EditText edtCargaHoraria = (EditText)this.findViewById(R.id.edtCargaHoraria);
	    
		Disciplina disciplina = new Disciplina();
		DisciplinaDAO dDAO = new DisciplinaDAO(this);
		
	    disciplina.setNome(edtNome.getText().toString());
		disciplina.setCargaHoraria(Integer.parseInt(edtCargaHoraria.getText().toString()));
		disciplina.setAtivo(1);
		
		if (disciplina.getNome() != null) {
			dDAO.inserir(disciplina);

			// Mostra a mensagem de confirmação do cadastro
			Toast.makeText(CadastroDisciplina.this,
					disciplina.getNome() + " Cadastrado com Sucesso",
					Toast.LENGTH_LONG).show();
		}
		
		
		
	}

	public void addAluno(View componente){		
		Intent intentNovaTela = new Intent(this, AdicionarAluno.class);
		EditText edtNome = (EditText)this.findViewById(R.id.edtNome);
		DisciplinaDAO dao = new DisciplinaDAO(this);		
		
		ID_DISCIPLINA = dao.retornarID(edtNome.getText().toString());
		intentNovaTela.putExtra("idDisciplina", ID_DISCIPLINA);
		CadastroDisciplina.this.startActivity(intentNovaTela);
	}	
}
