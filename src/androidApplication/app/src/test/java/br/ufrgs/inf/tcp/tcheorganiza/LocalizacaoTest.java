import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocalizacaoTest {

    @Test
    public void testGetters() {
        Localizacao local = new Localizacao("Campus Central", "Av. Brasil", "123", "Centro");

        assertEquals("Campus Central", local.getCampus());
        assertEquals("Av. Brasil", local.getRua());
        assertEquals("123", local.getNumero());
        assertEquals("Centro", local.getBairro());
    }

    @Test
    public void testToStringFormat() {
        Localizacao local = new Localizacao("UF", "Rua A", "45B", "Jardins");

        String esperado = "Rua A, 45B - Jardins (UF)";
        assertEquals(esperado, local.toString());
    }
}
