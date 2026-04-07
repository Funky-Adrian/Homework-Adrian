package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;

public class Partita {
    private Labirinto labirinto;
    private Stanza stanzaCorrente;
    private boolean finita;
    private Giocatore giocatore;

    public Partita() {
        this.labirinto = new Labirinto();
        this.giocatore = new Giocatore();
        this.stanzaCorrente = this.labirinto.getEntrata();
        this.finita = false;
    }


    public Labirinto getLabirinto() {
        return this.labirinto;
    }

 
    public Giocatore getGiocatore() {
        return this.giocatore;
    }


    public int getCfu() {
        return this.giocatore.getCfu();
    }

    public void setCfu(int cfu) {
        this.giocatore.setCfu(cfu);
    }
    
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }
    
    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaVincente() {
        return this.labirinto.getUscita();
    }
    
    public boolean isFinita() {
        return finita || vinta() || (this.giocatore.getCfu() == 0);
    }
    
    public boolean vinta() {
        return this.stanzaCorrente == this.getStanzaVincente();
    }

    public void setFinita() {
        this.finita = true;
    }
}