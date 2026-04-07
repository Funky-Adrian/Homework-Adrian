package test_diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaTest {
	private Stanza stanza;
	@BeforeEach
	void setUp() {
		this.stanza = new Stanza("Laboratorio");
	}
	//Qui 3 test su hasAttrezzo
	@Test
	void testHasAttrezzo_True() {
		Attrezzo martello = new Attrezzo("Martello", 2);
		this.stanza.addAttrezzo(martello);
		
		assertTrue(this.stanza.hasAttrezzo("Martello"), "L'attrezzo deve essere presente");
		
	}
	@Test
	void testHasAttrezzo_False() {
		assertFalse(this.stanza.hasAttrezzo("Mannaia"), "L'attrezzo non deve essere presente");
	}
	@Test
	void testHasAttrezzo_StanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("nulla"));
	}
	//Qui i 3 test su getStanzaAdiacente
	@Test
	void getStanzaAdiacente_Esiste() {
		Stanza adiacente = new Stanza("Ripostiglio");
		this.stanza.impostaStanzaAdiacente("nord", adiacente);
		
		assertSame(adiacente, this.stanza.getStanzaAdiacente("nord"), "Dovrebbe restituire la stanza impostata su nord");
	}
	@Test
	void getStanzaAdiacente_NonEsiste() {
		assertNull(this.stanza.getStanzaAdiacente("sud"), "In una direzione vuota dovrebbe restituire null");
	}
	@Test
	void getStanzaAdiacente_CambioStanza() {
		Stanza s1 = new Stanza("Stanza 1");
		Stanza s2 = new Stanza("Stanza 2");
		
		this.stanza.impostaStanzaAdiacente("nord", s1);
		this.stanza.impostaStanzaAdiacente("nord", s2);
		
		assertEquals(s2, this.stanza.getStanzaAdiacente("nord"), "A nord dovrebbe esserci l'ultima stanza inserita");
	}
}
