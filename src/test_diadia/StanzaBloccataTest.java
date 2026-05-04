package test_diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

//In questo caso il labirinto minimale è un "bilocale"

class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Attrezzo chiave;

	@BeforeEach
	void setUp() {
		this.stanzaBloccata = new StanzaBloccata("Corridoio", "nord", "chiave");
		this.stanzaAdiacente = new Stanza("Biblioteca");
		this.chiave = new Attrezzo("chiave", 1);
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
	}

	@Test
	void testGetStanzaAdiacenteDirezioneBloccataSenzaAttrezzo() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	void testGetStanzaAdiacenteDirezioneBloccataConAttrezzo() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
	}

	@Test
	void testGetStanzaAdiacenteDirezioneNonBloccata() {
		Stanza altraStanza = new Stanza("Cucina");
		stanzaBloccata.impostaStanzaAdiacente("sud", altraStanza);
		assertEquals(altraStanza, stanzaBloccata.getStanzaAdiacente("sud"));
	}

	@Test
	void testGetDescrizioneSenzaAttrezzo() {
		assertTrue(stanzaBloccata.getDescrizione().contains("bloccata"));
	}
}