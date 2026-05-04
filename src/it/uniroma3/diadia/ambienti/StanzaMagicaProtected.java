package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
    private int sogliaMagica;
    private int contatoreAttrezziPosati;
    private static final int SOGLIA_DEFAULT = 3;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.sogliaMagica = soglia;
        this.contatoreAttrezziPosati = 0;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati > this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }
        

        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[this.numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        }
        return false;
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse();
        int pesoRaddoppiato = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeInvertito.toString(), pesoRaddoppiato);
    }
}