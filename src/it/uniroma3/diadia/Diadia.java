package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


public class Diadia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public Diadia(IOConsole io) {
		this.io = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() == null) {
		    return false;
		}

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		} else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		} else {
			this.io.mostraMessaggio("Comando sconosciuto");
		}

		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else if (this.partita.isFinita()) {
			this.io.mostraMessaggio("Hai esaurito i CFU o la partita è finita.");
		    return true;
		}
		
		return false;
	}   

	private void prendi(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			this.io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}
		
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
		
		if (attrezzo != null) {
			if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				stanzaCorrente.removeAttrezzo(nomeAttrezzo);
				this.io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
			} else {
				this.io.mostraMessaggio("Borsa troppo piena o troppo pesante!");
			}
		} else {
			this.io.mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non è in questa stanza.");
		}
		this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}

	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			this.io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		Attrezzo attrezzo = borsa.getAttrezzo(nomeAttrezzo);
		
		if (attrezzo != null) {
			if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
				borsa.removeAttrezzo(nomeAttrezzo);
				this.io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
			} else {
				this.io.mostraMessaggio("Non c'è più spazio nella stanza!");
			}
		} else {
			this.io.mostraMessaggio("Non hai " + nomeAttrezzo + " nella borsa.");
		}
		this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
	}

	private void aiuto() {
		StringBuilder sb = new StringBuilder("Comandi disponibili: ");
		for(int i=0; i< elencoComandi.length; i++) 
			sb.append(elencoComandi[i] + " ");
		this.io.mostraMessaggio(sb.toString());
	}

	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare?");
		
		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
		} else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu - 1); 
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		Diadia gioco = new Diadia(io);
		gioco.gioca();
	}
}