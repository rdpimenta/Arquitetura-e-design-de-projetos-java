package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidosHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.List;

public class TestePedido {
    public static void main(String[] args) {
        GeraPedido geraPedido = new GeraPedido("Juliano", new BigDecimal("600"), 4);
        GeraPedidosHandler geraPedidosHandler = new GeraPedidosHandler(List.of(new EnviarEmailPedido(), new SalvarPedidoNoBancoDeDados()));

        geraPedidosHandler.executa(geraPedido);
    }
}
