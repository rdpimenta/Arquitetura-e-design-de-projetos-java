package escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailInvalido.com"));
    }

    @Test
    void deveriaCriarEmailsComEnderecoValido() {
        String endereco = "teste@teste.com";
        Email email = new Email("teste@teste.com");

        assertEquals(endereco, email.getEndereco());
    }
}
