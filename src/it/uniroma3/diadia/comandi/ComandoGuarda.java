package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU residui: " + partita.getGiocatore().getCfu());
		io.mostraMessaggio("Contenuto borsa: " + partita.getGiocatore().getBorsa().toString());
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() { return "guarda"; }

	@Override
	public String getParametro() { return null; }
}