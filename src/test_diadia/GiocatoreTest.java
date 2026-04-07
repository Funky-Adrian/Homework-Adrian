package test_diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.giocatore.Giocatore;
class GiocatoreTest {
    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        this.giocatore = new Giocatore();
    }

   
    @Test
    void testGetCfuIniziali() {
        assertEquals(20, this.giocatore.getCfu(), "Un nuovo giocatore deve iniziare con 20 CFU");
    }

    @Test
    void testSetCfu() {
        this.giocatore.setCfu(15);
        assertEquals(15, this.giocatore.getCfu(), "I CFU dovrebbero essere stati aggiornati a 15");
    }

    @Test
    void testGetBorsa() {
        assertNotNull(this.giocatore.getBorsa(), "Il giocatore deve avere un'istanza di Borsa valida");
    }
}