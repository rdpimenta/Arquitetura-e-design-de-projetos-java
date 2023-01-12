package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestePedido {
    public static void main(String[] args) {
        GeraPedido geraPedido = new GeraPedido("Juliano", new BigDecimal("600"), 4);

        geraPedido.executa();
    }
}
