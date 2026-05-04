package test_diadia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Diadia;
import it.uniroma3.diadia.IOSimulator;

class DiaDiaTest {

	@Test
	void testPartitaVinta() {
		
		String[] comandi = {"vai nord", "fine"}; 
		
		
		IOSimulator simulatore = new IOSimulator(comandi);
		
		
		Diadia gioco = new Diadia(simulatore);
		gioco.gioca();
		
		
		assertTrue(simulatore.getMessaggiProdotti().contains("Hai vinto!"));
	}

	
	@Test
	void testPartitaPersaPerCFU() {
	    String[] comandi = {
	        "vai sud", "vai nord", "vai sud", "vai nord", "vai sud", "vai nord",
	        "vai sud", "vai nord", "vai sud", "vai nord", "vai sud", "vai nord",
	        "vai sud", "vai nord", "vai sud", "vai nord", "vai sud", "vai nord",
	        "vai sud", "vai nord", "vai sud", "vai nord" 
	    };
	    
	    IOSimulator simulatore = new IOSimulator(comandi);
	    Diadia gioco = new Diadia(simulatore);
	    gioco.gioca();
	    
	    assertTrue(simulatore.getMessaggiProdotti().contains("Hai esaurito i CFU!"));
	}
}