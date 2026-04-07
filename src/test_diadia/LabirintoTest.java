package test_diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.ambienti.Labirinto;
class LabirintoTest {
    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        this.labirinto = new Labirinto();
    }

    
    @Test
    void testGetEntrata() {
        assertNotNull(this.labirinto.getEntrata(), "L'entrata non deve essere null");
        assertEquals("Atrio", this.labirinto.getEntrata().getNome(), "L'entrata dovrebbe essere l'Atrio");
    }

   
    @Test
    void testGetUscita() {
        assertNotNull(this.labirinto.getUscita(), "L'uscita non deve essere null");
        assertEquals("Biblioteca", this.labirinto.getUscita().getNome(), "L'uscita dovrebbe essere la Biblioteca");
    }

    @Test
    void testEntrataDiversaDaUscita() {
        assertNotSame(this.labirinto.getEntrata(), this.labirinto.getUscita(), "Entrata e uscita devono essere stanze distinte");
    }
}