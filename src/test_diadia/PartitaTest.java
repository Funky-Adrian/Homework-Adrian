package test_diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
class PartitaTest {

    private Partita partita;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
    }

    /* --- Test per vinta() --- */

    @Test
    void testVinta_InizioPartita() {
        // All'inizio non dovresti essere nella stanza vincente (Biblioteca)
        assertFalse(this.partita.vinta(), "La partita non dovrebbe essere vinta appena iniziata");
    }

    @Test
    void testVinta_StanzaVincente() {
        // Chiediamo al labirinto qual è la stanza vincente e ci teletrasportiamo lì
        Stanza vincente = this.partita.getLabirinto().getUscita();
        this.partita.setStanzaCorrente(vincente);
        assertTrue(this.partita.vinta(), "La partita deve risultare vinta se siamo nella stanza d'uscita");
    }

    /* --- Test per isFinita() --- */

    @Test
    void testIsFinita_Vittoria() {
        // Se vinciamo, la partita deve risultare finita
        this.partita.setStanzaCorrente(this.partita.getLabirinto().getUscita());
        assertTrue(this.partita.isFinita(), "Se vinta, la partita deve essere finita");
    }

    @Test
    void testIsFinita_CfuEsauriti() {
        // Ora i CFU sono nel Giocatore. Verifichiamo che se scendono a 0 la partita finisce.
        this.partita.getGiocatore().setCfu(0);
        assertTrue(this.partita.isFinita(), "La partita deve finire se il giocatore ha 0 CFU");
    }

    @Test
    void testIsFinita_InCorso() {
        // Test "al contrario": verifichiamo che all'inizio NON sia finita
        assertFalse(this.partita.isFinita(), "La partita non deve essere finita all'inizio");
    }

    /* --- Test per la Nuova Struttura (Delegazione) --- */

    @Test
    void testGetGiocatore() {
        // Verifichiamo che Partita abbia creato correttamente l'oggetto Giocatore
        assertNotNull(this.partita.getGiocatore(), "La partita deve avere un riferimento al giocatore");
    }

    @Test
    void testGetLabirinto() {
        // Verifichiamo che Partita abbia creato correttamente l'oggetto Labirinto
        assertNotNull(this.partita.getLabirinto(), "La partita deve avere un riferimento al labirinto");
    }
}