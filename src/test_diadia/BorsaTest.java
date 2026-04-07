package test_diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
    private Borsa borsa;

    @BeforeEach
    void setUp() {
        // 
        this.borsa = new Borsa();
    }

 
    @Test
    void testAddAttrezzo_Successo() {
        Attrezzo libro = new Attrezzo("Libro", 2);
        assertTrue(this.borsa.addAttrezzo(libro), "L'attrezzo dovrebbe essere aggiunto correttamente");
        assertTrue(this.borsa.hasAttrezzo("Libro"), "La borsa dovrebbe contenere il libro");
    }


    @Test
    void testAddAttrezzo_TroppoPesante() {
        Attrezzo incudine = new Attrezzo("Incudine", 11);
        assertFalse(this.borsa.addAttrezzo(incudine), "Non dovrebbe aggiungere un oggetto oltre i 10kg");
    }

    @Test
    void testRemoveAttrezzo_Esistente() {
        Attrezzo chiave = new Attrezzo("Chiave", 1);
        this.borsa.addAttrezzo(chiave);
        
        Attrezzo rimosso = this.borsa.removeAttrezzo("Chiave");
        
        assertEquals(chiave, rimosso, "Il metodo dovrebbe restituire l'oggetto rimosso");
        assertFalse(this.borsa.hasAttrezzo("Chiave"), "L'attrezzo non dovrebbe più essere presente");
    }
}