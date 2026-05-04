package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
    private String[] righeDaLeggere;     
    private int indiceRigaLetta;          
    private List<String> messaggiProdotti;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.indiceRigaLetta = 0;
        this.messaggiProdotti = new ArrayList<>();
    }

    @Override
    public String leggiRiga() {
        
        String riga = this.righeDaLeggere[indiceRigaLetta];
        this.indiceRigaLetta++;
        return riga;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
       
        this.messaggiProdotti.add(messaggio);
    }

 
    public List<String> getMessaggiProdotti() {
        return this.messaggiProdotti;
    }
    
  
    public String getMessaggio(int indice) {
        return this.messaggiProdotti.get(indice);
    }
}