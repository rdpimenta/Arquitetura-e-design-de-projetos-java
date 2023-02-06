package br.com.alura.escola.academico;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        MatricularAlunoDto dados = new MatricularAlunoDto(nome, cpf, email);

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionarOuvinte(new LogDeAlunoMatriculado());

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        matricularAluno.matricular(dados);
    }
}
