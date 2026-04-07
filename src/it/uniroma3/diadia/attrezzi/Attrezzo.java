package it.uniroma3.diadia.attrezzi;




public class Attrezzo {

	private String nome;
	private int peso;

	
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	
	public String getNome() {
		return this.nome;
	}

	
	public int getPeso() {
		return this.peso;
	}

	
	public String toString() {
	    if (this.nome != null) {
	        return this.nome + " (" + this.peso + "kg)";
	    } else {
	        return "Attrezzo senza nome (" + this.peso + "kg)";
	    }
	}

}