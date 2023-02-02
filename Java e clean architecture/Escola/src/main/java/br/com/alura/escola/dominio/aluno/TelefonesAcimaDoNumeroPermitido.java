package br.com.alura.escola.dominio.aluno;

public class TelefonesAcimaDoNumeroPermitido extends IllegalArgumentException {
    public TelefonesAcimaDoNumeroPermitido() {
        super("Cada aluno só pode ter no máximo dois telefones.");
    }
}
