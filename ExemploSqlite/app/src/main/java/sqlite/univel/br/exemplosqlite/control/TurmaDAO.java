package sqlite.univel.br.exemplosqlite.control;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sqlite.univel.br.exemplosqlite.model.Turma;

/**
 * Created by Will on 23/05/2016.
 * DAO para create/read/update/delete de turma
 */
public class TurmaDAO {

    /**
     * Classe que fornece acesso a base de dados Sqlite
     */
    private final SqlitePersistencia database;
    /**
     * Colunas que são listadas da tabela
     */
    private static final String[] COLUMNS = new String[]{"id_turma", "descricao", "ano"};

    public TurmaDAO(final SqlitePersistencia database) {
        this.database = database;
    }

    /**
     * Método para realizar o insert de registros na tabela turma
     *
     * @param turma
     */
    public void create(final Turma turma) {
        //Deve ser utilizado o contentValues para isso
        //Não é informado o id devido a este ser auto incremento, não precisa informar a base de dados gera
        final ContentValues values = new ContentValues();
        values.put("descricao", turma.getDescricao());
        values.put("ano", turma.getAno());
        //Recupera o writer do Sqlite para persistir a informação
        final SQLiteDatabase writer = this.database.getWritableDatabase();
        writer.insert("turma", null, values);
        //Sempre apos escrever deve ser feito close
        writer.close();
    }

    /**
     * Faz update de um registro na base de dados
     *
     * @param turma
     */
    public void edit(final Turma turma) {
        if (turma.getIdTurma() == null || turma.getIdTurma() == 0) {
            //Se a turma não tem ID é que ainda não foi persistida, portanto não pode ser feito update, primeiro deve ser feito update
            create(turma);
            return;
        }
        //Para fazer update é precisa setar o valores em contentvalues igual ao insert, porém para este caso ja temos um ID definido
        final ContentValues values = new ContentValues();
        values.put("descricao", turma.getDescricao());
        values.put("ano", turma.getAno());
        //Recupera o writer que permite que seja escrito na base de dados
        final SQLiteDatabase writer = this.database.getWritableDatabase();
        //Faz update do registro na base, porém deve ser um informado uma condição para que não seja feito update em todos os registros por isso é utilizado id_turma = ? e depois passado como parametro o valor para id
        writer.update("turma", values, "id_turma = ?", new String[]{turma.getIdTurma().toString()});
        //Sempre apos escrever deve ser feito close
        writer.close();
    }

    /**
     * Remove um registro da base de dados
     *
     * @param turma
     */
    public void remove(final Turma turma) {
        //Faz o remove de registros da tabela, porém deve ser utilizado um where para não deletar todos os registros, com o where é possivel deletar apenas alguns registros
        final SQLiteDatabase writer = this.database.getWritableDatabase();
        //id_turma = ? é uma restrição para que seja deletado apenas alguns registros, apos este é passado um parametros com o valor para o parametro ?
        writer.delete("turma", "id_turma = ?", new String[]{turma.getIdTurma().toString()});
        //Sempre apos escrever deve ser feito close. Delete também é escrever
        writer.close();
    }

    /**
     * Faz uma busca na base de dados buscando todos os registros existentes na tabela turma
     *
     * @return
     */
    public List<Turma> get() {
        //Recupera o reader da base de dados
        final SQLiteDatabase reader = this.database.getReadableDatabase();
        //o método query é utilizado para fazer sql na base de dados. Apos executar é retornado um cursor que se comporta de forma parecida com um ResultSet
        final Cursor cursor = reader.query("turma", COLUMNS, /*where*/null, /*args where*/null, /*groupBy*/null, /*having*/ null, /*orderBy*/ null);
        final List<Turma> turmas = new ArrayList<Turma>(cursor.getCount());
        //Após recuperar o cursor este deve ser movido para o inicio para começar a percorre
        cursor.moveToFirst();
        //Percorre todo o cursor e recupera os valores existentes neste para montar os objetos de turma
        for (int index = 0; index < cursor.getCount(); index++) {
            //No cursor não existe um metodo para recuperar o valor pelo nome do campo, apenas pelo indice, portanto é preciso saber o indice da coluna para recuperar o valor, o indice é possivel de recuperar pelo nome da coluna
            int indexColumn = cursor.getColumnIndex("id_turma");
            Integer idTurma = cursor.getInt(indexColumn);
            indexColumn = cursor.getColumnIndex("descricao");
            String descricao = cursor.getString(indexColumn);
            indexColumn = cursor.getColumnIndex("ano");
            Integer ano = cursor.getInt(indexColumn);
            //Seta as informações de turma e adiciona a lista
            Turma turma = new Turma();
            turma.setIdTurma(idTurma);
            turma.setDescricao(descricao);
            turma.setAno(ano);
            turmas.add(turma);
            //Após percorrer este item da lista é necessário executar o next para que seja possivel percorrer o proximo
            cursor.moveToNext();
        }
        //Após utilizar o cursor e o reader é necessário fechar os mesmo
        cursor.close();
        reader.close();
        return turmas;
    }

    /**
     * Retorna a turma correspondente ao idTurma passado por parametro, caso não seja encontrado a turma correspondente retorna null
     *
     * @param idTurma
     * @return
     */
    public Turma get(final Integer idTurma) {
        //Recupera o reader para leitura da base de dados
        final SQLiteDatabase reader = this.database.getReadableDatabase();
        //Executa a query para recuperar o registro correspondente
        final Cursor cursor = reader.query("turma", COLUMNS, /*where*/"id_turma = ?", /*args where*/new String[]{idTurma.toString()}, /*groupBy*/null, /*having*/ null, /*orderBy*/ null, /*limit*/ "1");
        if (cursor != null) {
            //Move o cursor para a primeira posicao para fazer a leitura da turma que esta na primeira linha
            cursor.moveToFirst();
            //No cursor não existe um metodo para recuperar o valor pelo nome do campo, apenas pelo indice, portanto é preciso saber o indice da coluna para recuperar o valor, o indice é possivel de recuperar pelo nome da coluna
            int indexColumn = cursor.getColumnIndex("id_turma");
            final Integer idTurm = cursor.getInt(indexColumn);
            indexColumn = cursor.getColumnIndex("descricao");
            final String descricao = cursor.getString(indexColumn);
            indexColumn = cursor.getColumnIndex("ano");
            final Integer ano = cursor.getInt(indexColumn);
            //Seta as informações de turma
            final Turma turma = new Turma();
            turma.setIdTurma(idTurm);
            turma.setDescricao(descricao);
            turma.setAno(ano);
            //Após o uso de cursor e reader é necessario fechar os mesmos
            reader.close();
            cursor.close();
            return turma;
        }
        //É fechar aqui també, caso o cursor seja null, ele não entra no if e não será fechado dentro do if então deve ser fechado aqui
        reader.close();
        return null;
    }
}
