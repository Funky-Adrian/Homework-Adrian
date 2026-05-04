package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
		
		if (this.direzioneBloccata.equals(dir) && !this.hasAttrezzo(this.attrezzoSbloccante)) {
			return this; 
		}
		return super.getStanzaAdiacente(dir);
	}

	
	@Override
	public String getDescrizione() {
		String descrizioneBase = super.getDescrizione();
		
		
		if (!this.hasAttrezzo(this.attrezzoSbloccante)) {
			return descrizioneBase + "\n[ATTENZIONE] L'uscita a " + this.direzioneBloccata + 
					" è bloccata! Ti serve un '" + this.attrezzoSbloccante + "' in questa stanza per aprirla.";
		}
		
	
		return descrizioneBase + "\n[INFO] L'uscita a " + this.direzioneBloccata + " è stata sbloccata.";
	}
}