package test_diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {
    private Partita partita;
    private ComandoVai comando;
    private IO io;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.comando = new ComandoVai();
        this.io = new IOConsole();
    }

    @Test
    void testEsegui_SpostamentoValido() {
        comando.setParametro("nord");
        comando.esegui(this.partita, this.io);
        assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
    }

    @Test
    void testEsegui_DirezioneInesistente() {
        comando.setParametro("direzione_vuota");
        comando.esegui(this.partita, this.io);
        assertEquals("Atrio", partita.getStanzaCorrente().getNome());
    }

    @Test
    void testEsegui_ParametroNull() {
        comando.setParametro(null);
        comando.esegui(this.partita, this.io);
        assertEquals("Atrio", partita.getStanzaCorrente().getNome());
    }
}