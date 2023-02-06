package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.Evento;
import br.com.alura.escola.academico.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {
    @Override
    public void reageAo(Evento evento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = evento.momento().format(formatter);
        System.out.println(String.format(
                "Aluno com CPF %s matriculado em: %s",
                ((AlunoMatriculado) evento).getCpfDoAluno().getNumero(), dataFormatada
        ));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
