package br.com.alura.escola.academico.dominio.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    void naoDeveriaAdicionarMaisQueDoisNumerosDeTelefone() {
        Aluno aluno = new Aluno(
                "Fulano",
                new CPF("123.456.789-10"),
                new Email("email@email.com")
        );

        aluno.adicionarTelefone("31", "123456781");
        aluno.adicionarTelefone("31", "123456782");

        Assertions.assertThrows(TelefonesAcimaDoNumeroPermitido.class, () ->
                aluno.adicionarTelefone("31", "123456783")
        );
    }
}
