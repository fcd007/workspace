package sqlite.univel.br.exemplosqlite.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sqlite.univel.br.exemplosqlite.R;
import sqlite.univel.br.exemplosqlite.control.SqlitePersistencia;
import sqlite.univel.br.exemplosqlite.control.TurmaDAO;
import sqlite.univel.br.exemplosqlite.model.Turma;

/**
 * Created by juliano on 5/30/16.
 */
public class MainActivity extends Activity {

    private Turma turma;
    private EditText txtDescricao;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_cadastrar_turma);
        txtDescricao = (EditText) findViewById(R.id.txtDescricao);
        final Integer idTurma = getIntent().getIntExtra("idTurma", -1);
        if(idTurma != -1){
            turma = new TurmaDAO(new SqlitePersistencia(this)).get(idTurma);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(turma != null){
            txtDescricao.setText(turma.getDescricao());
        }
    }

    public void cadastrarTurmar(final View view){
        final Intent intent = new Intent(this, CadastrarTurmaActivity.class);
        this.startActivity(intent);

    }

    public void listarTurma(final View view){

    }

    public void gravar(){
        try {
            final String descricao = txtDescricao.getText().toString();
            if (descricao == null || descricao.trim().length() == 0) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.descricao_obrigatoria);
                builder.create().show();
            } else {
                if (turma == null) {
                    turma = new Turma();
                    turma.setDescricao(descricao);
                    new TurmaDAO(new SqlitePersistencia(this)).create(turma);
                }
            }
        }catch (final Exception e){
            e.printStackTrace();
            Toast.makeText(this, R.string.catastrofico, Toast.LENGTH_LONG).show();
        }
    }
}
