package test_diadia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
    private Partita partita;
    private ComandoPrendi comando;
    private IO io;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPrendi();
        this.io = new IOConsole();
    }

    @Test
    void testEsegui_AttrezzoPresoCorrettamente() {
        Attrezzo attrezzo = new Attrezzo("martello", 1);
        partita.getStanzaCorrente().addAttrezzo(attrezzo);
        comando.setParametro("martello");
        comando.esegui(this.partita, this.io);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
    }

    @Test
    void testEsegui_AttrezzoNonPresente() {
        comando.setParametro("inesistente");
        comando.esegui(this.partita, this.io);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("inesistente"));
    }
}