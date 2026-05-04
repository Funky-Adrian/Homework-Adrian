package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if (nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (attrezzo != null) {
			if (partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
			} else {
				io.mostraMessaggio("Non c'è spazio nella stanza!");
			}
		} else {
			io.mostraMessaggio("Non hai questo attrezzo in borsa.");
		}
	}

	@Override
	public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }

	@Override
	public String getNome() { return "posa"; }

	@Override
	public String getParametro() { return this.nomeAttrezzo; }
}