package br.com.alura.escola.academico.infra.selo;

import br.com.alura.escola.academico.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.academico.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {
    List<Selo> selos = new ArrayList<>();

    @Override
    public void aplicarSelo(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> listarTodosOsSelosDeAlunoPorCPF(CPF cpf) {
        return this.selos.stream().filter(selo -> selo.getCpfDoAluno() == cpf).collect(Collectors.toList());
    }
}
