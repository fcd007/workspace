package br.univel.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner spnSexo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// M�todo sempre � invocado quando a activity esta sendo construida,
		// apenas neste momento, ap�s isso n�o � chamado novamente. Pode ser
		// utilizado para as configura��es da tela
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("MainActivity.onCreate()");
		spnSexo = (Spinner) findViewById(R.id.spnSexo);
	}

	@Override
	protected void onStart() {
		// M�todo invocado logo ap�s o onCreate, quando este metodo � invocado a
		// tela ainda n�o esta visivel ao usuario e pode ser feito algumas
		// configura��es ainda
		super.onStart();
		System.out.println("MainActivity.onStart()");
		spnSexo.setAdapter(
				ArrayAdapter.createFromResource(this, R.array.array_sexo, android.R.layout.simple_spinner_item));
	}

	@Override
	protected void onResume() {
		// M�todo chamado logo ap�s o onStart, por�m neste ponto a tela j� esta
		// visivel ao usu�rio, ent�o n�o se deve fazer configura��o na tela
		// neste ponto
		super.onResume();
		System.out.println("MainActivity.onResume()");
	}

	@Override
	protected void onPause() {
		// M�todo � invocado quando a tela perde o foco por qualquer motivo,
		// por�m enquanto a execu��o deste m�todo n�o for conclu�do a tela ainda
		// esta visivel ao usu�rio, portanto n�o deve ser lenta a execu��o deste
		super.onPause();
		System.out.println("MainActivity.onPause()");
	}

	@Override
	protected void onStop() {
		// onStop executado logo ap�s o onPause, por�m para este a activity n�o
		// esta mais visivel ao usu�rio, ent�o podemos ter um c�digo com
		// execu��o lenta
		super.onStop();
		System.out.println("MainActivity.onStop()");
	}

	@Override
	protected void onRestart() {
		// Invocado ap�s o onStop ter sido executado e a tela receber novamente
		// o foco
		super.onRestart();
		System.out.println("MainActivity.onRestart()");
	}

	@Override
	protected void onDestroy() {
		// Invocado quando o activity esta sendo destruido pelo android, ap�s a
		// execu��o deste m�todo nenhum outro metodo do ciclo de vida do objeto
		// ser� chamado, para ter a activity novamente vai ser necess�rio
		// recriar
		super.onDestroy();
		System.out.println("MainActivity.onDestroy()");
	}

	public void abreActivity(View view) {
		Intent intent = new Intent(this, CadastroActivity.class);
		// Inicia uma nova instancia de activity, sem passagem de parametros
		this.startActivity(intent);
		// Inicia uma nova instancia da activity com a passagem de parametros
		// this.startActivity(intent, options);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void createPessoa(final View view) {
		Toast.makeText(getApplicationContext(), "Pessoa salva com sucesso!", Toast.LENGTH_LONG).show();
	}
}
