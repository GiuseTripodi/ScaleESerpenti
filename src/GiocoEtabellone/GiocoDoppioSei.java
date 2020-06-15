package GiocoEtabellone;

import Giocatore.Giocatore;

public class GiocoDoppioSei extends  AbstractGioco{
    private final int numDadi = 2;

    public GiocoDoppioSei(Tabellone tabellone){
        super(tabellone);
    }

    @Override
    public void mossa(Giocatore giocatore) {
        rimuoviDaUltimaCella(giocatore);
        int esitoLancio = lancio(numDadi);
        System.out.println("Il risultato del lancio è : "+ esitoLancio);
        muovi(giocatore, esitoLancio);
        if(esitoLancio == 12){
            rimuoviDaUltimaCella(giocatore);
            esitoLancio = lancio(numDadi);
            muovi(giocatore, esitoLancio);
        }
        verificaPremio(giocatore, esitoLancio);


    }
}
