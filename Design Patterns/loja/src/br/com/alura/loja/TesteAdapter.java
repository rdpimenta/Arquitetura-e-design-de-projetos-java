package br.com.alura.loja;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TesteAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("600")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("600")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("600")));
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("600")));
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());

        registroDeOrcamento.registrar(orcamento);
    }
}
