package br.com.alura.escola.academico.dominio.selo;

import br.com.alura.escola.academico.dominio.aluno.CPF;

import java.util.List;

public interface RepositorioDeSelos {
    void aplicarSelo(Selo selo);
    List<Selo> listarTodosOsSelosDeAlunoPorCPF(CPF cpf);
}
