package br.com.alura.escola.academico.dominio.indicacao;

import br.com.alura.escola.academico.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {
    private Aluno indicado;
    private Aluno indicante;
    private LocalDateTime dataDeIndicacao;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataDeIndicacao = LocalDateTime.now();
    }

    public Aluno getIndicado() {
        return indicado;
    }

    public Aluno getIndicante() {
        return indicante;
    }

    public LocalDateTime getDataDeIndicacao() {
        return dataDeIndicacao;
    }
}
