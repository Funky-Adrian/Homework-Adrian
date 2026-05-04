package test_diadia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;


class PartitaTest {

    private Partita partita;
    private IO io;

    @BeforeEach
    void setUp() {
        this.partita = new Partita();
        this.io = new IOConsole();
    }

    @Test
    void testVinta_TramiteComando() {

        Comando vai = new ComandoVai();

        vai.setParametro("nord"); 

        vai.esegui(this.partita, this.io);
        

        assertTrue(this.partita.vinta());
    }

    @Test
    void testVinta_InizioPartita() {
     
        assertFalse(this.partita.vinta(), "La partita non dovrebbe essere vinta appena iniziata");
    }

    @Test
    void testVinta_StanzaVincente() {
      
        Stanza vincente = this.partita.getLabirinto().getUscita();
        this.partita.setStanzaCorrente(vincente);
        assertTrue(this.partita.vinta(), "La partita deve risultare vinta se siamo nella stanza d'uscita");
    }

    

    @Test
    void testIsFinita_Vittoria() {
      
        this.partita.setStanzaCorrente(this.partita.getLabirinto().getUscita());
        assertTrue(this.partita.isFinita(), "Se vinta, la partita deve essere finita");
    }

    @Test
    void testIsFinita_CfuEsauriti() {
   
        this.partita.getGiocatore().setCfu(0);
        assertTrue(this.partita.isFinita(), "La partita deve finire se il giocatore ha 0 CFU");
    }

    @Test
    void testIsFinita_InCorso() {
    
        assertFalse(this.partita.isFinita(), "La partita non deve essere finita all'inizio");
    }

  

    @Test
    void testGetGiocatore() {
        
        assertNotNull(this.partita.getGiocatore(), "La partita deve avere un riferimento al giocatore");
    }

    @Test
    void testGetLabirinto() {
        
        assertNotNull(this.partita.getLabirinto(), "La partita deve avere un riferimento al labirinto");
    }
}