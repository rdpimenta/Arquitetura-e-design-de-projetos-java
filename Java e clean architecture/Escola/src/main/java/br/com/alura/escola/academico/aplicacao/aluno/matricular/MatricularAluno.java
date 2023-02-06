package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

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
