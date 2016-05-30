package sqlite.univel.br.exemplosqlite.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Will on 23/05/2016.
 * Classe para interagir com o banco de dados Sqlite, para isso é utilizado o extends SqliteOpenHelper
 */
public class SqlitePersistencia extends SQLiteOpenHelper {

    public SqlitePersistencia(final Context context) {
        //Define as informações básica para o banco de dados, sendo o nome do mesmo e a versão
        super(context, context.getPackageName(), null, 1);
    }

    @Override
    public void onConfigure(final SQLiteDatabase db) {
        super.onConfigure(db);
        //Bando Sqlite não traz as FKs habilitadas, portanto é preciso habilitar o uso de FK na base de dados, e isso que o codigo abaixo faz
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        //onCreate e executado quando o banco de dados ainda nao existe e vai ser criado pela aplicacao, este metodo e chamado quando é tentado acessar o banco e não encontrado, então é chamado este metodo para criar a base dedados
        try {
            //Para criar as tabelas podemos utilizar sql simples conforme abaixo
            final StringBuffer sql = new StringBuffer();
            sql.append("CREATE TABLE turma(id_turma integer primary key autoincrement, descricao text, ano integer); ");
            sql.append("CREATE TABLE aluno(id_aluno integer primary key autoincrement, nome text, id_turma integer, FOREIGN KEY (id_turma) REFERENCES turma(id_turma));");
            db.execSQL(sql.toString());
        } catch (final Exception e) {
            System.err.println("Erro ao criar base de dados");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Metodo é invocado quando existe a necessidade de atualizar a base de dados
    }
}
