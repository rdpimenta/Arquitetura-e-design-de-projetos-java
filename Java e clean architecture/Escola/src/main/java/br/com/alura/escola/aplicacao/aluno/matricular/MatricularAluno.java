package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.PublicadorDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorioDeAlunos;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos, PublicadorDeEventos publicador) {
        this.repositorioDeAlunos = repositorioDeAlunos;
        this.publicador = publicador;
    }

    public void matricular(MatricularAlunoDto dados) {
        Aluno aluno = dados.criarAluno();

        repositorioDeAlunos.matricular(aluno);

        AlunoMatriculado evento = new AlunoMatriculado(new CPF(aluno.getCpf()));
        publicador.publicar(evento);
    }
}
