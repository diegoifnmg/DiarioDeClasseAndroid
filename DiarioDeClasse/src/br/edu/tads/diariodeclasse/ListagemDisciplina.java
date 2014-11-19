package br.edu.tads.diariodeclasse;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import br.edu.tads.DataAcess.DisciplinaDAO;
import br.edu.tads.Model.Disciplina;

public class ListagemDisciplina extends Activity {

	// Variaveis...............................................
	private ListView lstDisciplinas;
	private List<Disciplina> listaDisciplina;

	// O ArrayAdapter sabe converter listas ou vetores em View
	private ArrayAdapter<Disciplina> adapter;

	// Definicao do layout de exibicao da listagem
	private int adapterLayout = android.R.layout.simple_list_item_1;

	// Método onCreate..........................................
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listagem_disciplina);

		// Ligacao dos componentes de TELA aos atributos da Activity
		lstDisciplinas = (ListView) findViewById(R.id.lstDisciplinas);

		// Informa que a ListView tem Menu de Contexto
		registerForContextMenu(lstDisciplinas);
	}

	// Metodo que carrega os itens da lista na tela...........................
	public void carregarLista() {

		DisciplinaDAO dao = new DisciplinaDAO(this);
		this.listaDisciplina = dao.listar();
		// dao.close();

		// O objeto ArrayAdapter sabe converter listas ou vetores em View
		this.adapter = new ArrayAdapter<Disciplina>(this, adapterLayout,
				listaDisciplina);

		// Associacao do Adapter a ListView
		this.lstDisciplinas.setAdapter(adapter);
	}

	// .......................................................................
	@Override
	protected void onResume() {
		super.onResume();
		this.carregarLista();
	}

	// Método para o evento de click longo em um item da lista...............
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Selecione uma Opção:");
		menu.add(0, v.getId(), 0, "Adicionar Aluno");// groupId, itemId, order,
														// title
		menu.add(0, v.getId(), 0, "Editar");
		menu.add(0, v.getId(), 0, "Excluir");
	}

	// Método para configuração da opção selecionada nas opções da lista......
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		DisciplinaDAO dao = new DisciplinaDAO(this);
		Disciplina disciplina = new Disciplina();
		
		AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		long selectid = menuinfo.id;

		// Condicional para a opção selecionada
		if (item.getTitle() == "Abrir") {
			
			//projeto = dao.retornaProjetoPosicao((int) selectid);
			
			//Intent intent = new Intent(ListagemDisciplina.this, .class);
			
			//intent.putExtra("Id", projeto.getId());

			//ListagemDisciplina.this.startActivity(intent);

		} else if (item.getTitle() == "Editar") {
			
			Toast.makeText(getApplicationContext(),
					"Opção EDITAR - Projeto: ",
					Toast.LENGTH_LONG).show();
		} else if (item.getTitle() == "Excluir") {
			

			Toast.makeText(getApplicationContext(),
					"Opção EXCLUIR - Projeto: ",
					Toast.LENGTH_LONG).show();
		} else {
			return false;
		}
		return true;
	}

	// Método onCreateOptionsMenu...............................
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listagem_disciplina, menu);
		return true;
	}

}
