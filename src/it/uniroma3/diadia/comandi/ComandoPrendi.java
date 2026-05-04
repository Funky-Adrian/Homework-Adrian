package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if (nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attrezzo != null) {
			if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
			} else {
				io.mostraMessaggio("Borsa troppo piena!");
			}
		} else {
			io.mostraMessaggio("Attrezzo non presente nella stanza.");
		}
	}

	@Override
	public void setParametro(String parametro) { this.nomeAttrezzo = parametro; }

	@Override
	public String getNome() { return "prendi"; }

	@Override
	public String getParametro() { return this.nomeAttrezzo; }
}