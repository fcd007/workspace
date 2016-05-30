package sqlite.univel.br.exemplosqlite.model;

/**
 * Created by Will on 23/05/2016.
 * Classe que representa uma turma no sistema
 */
public class Turma {

    /**
     * Id da da turma é utilizado como primary key para a tabela
     */
    private Integer idTurma;
    /**
     * Descricao da turma
     */
    private String descricao;
    /**
     * Ano da turma
     */
    private Integer ano;

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
