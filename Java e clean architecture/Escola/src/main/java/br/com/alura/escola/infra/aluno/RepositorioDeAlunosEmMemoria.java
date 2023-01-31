package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {
    private List<Aluno> listaDeAlunos = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.listaDeAlunos.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return this.listaDeAlunos.stream()
                .filter(aluno1 -> aluno1.getCpf().matches(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.listaDeAlunos;
    }
}
