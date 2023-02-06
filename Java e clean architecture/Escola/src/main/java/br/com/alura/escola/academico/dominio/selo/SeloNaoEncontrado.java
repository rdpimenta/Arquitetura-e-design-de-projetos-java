package br.com.alura.escola.academico.dominio.selo;

public class SeloNaoEncontrado extends IllegalArgumentException{
    public SeloNaoEncontrado(String nome) {
        super("Selo nao encontrado com o nome: " + nome);
    }
}
