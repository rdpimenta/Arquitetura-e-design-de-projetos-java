package escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CPFTest {
    @Test
    void naoDeveriaCriarCpfsComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("15484948156198"));
    }

    @Test
    void DeveriaCriarCpfsComNumeroValido() {
        String numero = "123.456.789-10";
        CPF cpf = new CPF("123.456.789-10");
        assertEquals(numero, cpf.getNumero());
    }
}
