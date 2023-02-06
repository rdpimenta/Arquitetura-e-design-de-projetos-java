package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.academico.dominio.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {
    @Test
    void alunoDeveriaSerPersistido() {
        RepositorioDeAlunos repositorioDeAlunos = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        MatricularAluno matricularAluno = new MatricularAluno(repositorioDeAlunos, publicador);
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
