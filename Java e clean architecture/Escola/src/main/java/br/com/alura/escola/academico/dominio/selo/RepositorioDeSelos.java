package br.com.alura.escola.academico.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelos {
    void aplicarSelo(Selo selo);
    List<Selo> listarTodosOsSelosDeAlunoPorCPF(CPF cpf);
}
