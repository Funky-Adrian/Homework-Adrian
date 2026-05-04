package test_diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

//viene utilizzato un setup "monolocale"

class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@BeforeEach
	void setUp() {
		this.stanza = new StanzaBuia("Soggiorno", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	void testGetDescrizioneSenzaAttrezzo() {
		assertEquals("qui c'è un buio pesto", stanza.getDescrizione());
	}

	@Test
	void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(lanterna);
		assertNotEquals("qui c'è un buio pesto", stanza.getDescrizione());
		assertTrue(stanza.getDescrizione().contains(lanterna.toString()));
	}
}