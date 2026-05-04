package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


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

	private Partita partita;
	private IO io;

	public Diadia(IO io) {
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
	    Comando comandoDaEseguire;
	    FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	    
	    comandoDaEseguire = factory.costruisciComando(istruzione);
	    
	
	    comandoDaEseguire.esegui(this.partita, this.io); 

	

		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		}
		
		if (this.partita.getGiocatore().getCfu() == 0) {
			this.io.mostraMessaggio("Hai esaurito i CFU!");
			return true;
		}
		
		if (this.partita.isFinita()) {
			return true;
		}
		
		return false;
	}   

	public static void main(String[] argc) {
		IO io = new IOConsole();
		Diadia gioco = new Diadia(io);
		gioco.gioca();
	}
}