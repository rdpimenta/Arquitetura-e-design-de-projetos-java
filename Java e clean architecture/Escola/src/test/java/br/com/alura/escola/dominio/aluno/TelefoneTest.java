package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {
    @Test
    void naoDeveriaCriarTelefonesComNumeroOuDddInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "12345678910"));
    }

    @Test
    void deveriaCriarTelefonesComNumeroEDddValidos() {
        String ddd = "12";
        String numero1 = "12345678";
        String numero2 = "123456789";

        Telefone telefone1 = new Telefone(ddd, numero1);
        assertEquals(ddd, telefone1.getDdd());
        assertEquals(numero1, telefone1.getNumero());

        Telefone telefone2 = new Telefone(ddd, numero2);
        assertEquals(numero2, telefone2.getNumero());
    }
}
