package test_diadia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;


class ComandoPosaTest {
    private Partita partita;
    private ComandoPosa comando;
    private IO io;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoPosa();
        this.io = new IOConsole();
    }

    @Test
    void testEsegui_AttrezzoPosatoCorrettamente() {
        Attrezzo attrezzo = new Attrezzo("libro", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        comando.setParametro("libro");
        comando.esegui(this.partita, this.io);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
        assertTrue(partita.getStanzaCorrente().hasAttrezzo("libro"));
    }

    @Test
    void testEsegui_BorsaVuota() {
        comando.setParametro("chiave");
        comando.esegui(this.partita, this.io);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));
    }
}