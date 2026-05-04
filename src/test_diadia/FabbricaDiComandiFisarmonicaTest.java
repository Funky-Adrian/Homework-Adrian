package test_diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica fabbrica;

    @BeforeEach
    void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    @Test
    void testCostruisciComando_Vai() {
        Comando eseguito = fabbrica.costruisciComando("vai nord");
        assertEquals("vai", eseguito.getNome());
        assertEquals("nord", eseguito.getParametro());
    }

    @Test
    void testCostruisciComando_Fine() {
        Comando eseguito = fabbrica.costruisciComando("fine");
        assertEquals("fine", eseguito.getNome());
        assertNull(eseguito.getParametro());
    }

    @Test
    void testCostruisciComando_NonValido() {
        Comando eseguito = fabbrica.costruisciComando("comando_inesistente");
        assertEquals("sconosciuto", eseguito.getNome());
    }
}