package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.academico.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.academico.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.util.Map;

public class GeraSeloAlunoNovato extends Ouvinte {
    private RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpf = (CPF) evento.informacoes().get("cpf");
        Selo selo = new Selo(cpf, "Novato");
        repositorioDeSelos.aplicarSelo(selo);
    }
}
