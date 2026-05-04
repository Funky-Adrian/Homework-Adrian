package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;

    @Override
    public void esegui(Partita partita, IO io) {
        String direzione = getParametro();
        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?");
            return;
        }

        Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente");
        } else {
            partita.setStanzaCorrente(prossimaStanza);
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
        }
        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }
}