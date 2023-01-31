package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {
    @Test
    void alunoDeveriaSerPersistido() {
        RepositorioDeAlunos repositorioDeAlunos = new RepositorioDeAlunosEmMemoria();
        MatricularAluno matricularAluno = new MatricularAluno(repositorioDeAlunos);
        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Fulano", "123.456.789-10", "email@email.com"
        );

        matricularAluno.matricular(dados);

        Aluno encontrado = repositorioDeAlunos.buscarPorCpf(new CPF("123.456.789-10"));

        Assertions.assertEquals("Fulano", encontrado.getNome());
        Assertions.assertEquals("123.456.789-10", encontrado.getCpf());
        Assertions.assertEquals("email@email.com", encontrado.getEmail());
    }
}
