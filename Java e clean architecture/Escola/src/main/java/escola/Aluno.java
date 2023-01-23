package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private CPF cpf;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(String nome, CPF cpf, Email email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }
}
