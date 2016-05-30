package sqlite.univel.br.exemplosqlite.model;

/**
 * Created by Will on 23/05/2016.
 * Classe que representa um aluno na aplicacao, sendo persistida no base Sqlite
 */
public class Aluno {

    /**
     * Id do aluno é utilizado como chave primary da tabela
     */
    private Integer idAluno;
    /**
     * Nome do aluno a ser definido na aplicacao
     */
    private String nome;
    /**
     * Turma a qual o aluno pertence, sendo um FK na tabela de turma
     */
    private Turma turma;

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
