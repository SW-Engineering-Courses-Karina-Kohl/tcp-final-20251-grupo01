import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrganizadorRusTest {

    private OrganizadorRus organizador;

    @BeforeEach
    public void setUp() {
        organizador = new OrganizadorRus();
    }

    @Test
    public void testAdicionarRuOrdenado() {
        Ru ru2 = new Ru("RU02", null, null, null);
        Ru ru1 = new Ru("RU01", null, null, null);

        organizador.adicionarRu(ru2);
        organizador.adicionarRu(ru1);

        List<Ru> lista = organizador.getRus();
        assertEquals("RU01", lista.get(0).getNome());
        assertEquals("RU02", lista.get(1).getNome());
    }

    @Test
    public void testBuscarRUExistente() {
        Ru ru = new Ru("RU01", null, null, null);
        organizador.adicionarRu(ru);

        Ru resultado = organizador.buscarRU("RU01");
        assertNotNull(resultado);
        assertEquals("RU01", resultado.getNome());
    }

    @Test
    public void testBuscarRUNaoExistente() {
        assertThrows(RuNaoEncontradoException.class, () -> {
            organizador.buscarRU("RU99");
        });
    }

    @Test
    public void testRemoverRUExistente() {
        Ru ru = new Ru("RU01", null, null, null);
        organizador.adicionarRu(ru);

        boolean resultado = organizador.removerRU("RU01");
        assertTrue(resultado);
        assertTrue(organizador.getRus().isEmpty());
    }

    @Test
    public void testRemoverRUNaoExistente() {
        boolean resultado = organizador.removerRU("RU99");
        assertFalse(resultado);
    }
}
