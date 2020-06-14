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
        muovi(giocatore, esitoLancio);
        if(esitoLancio == 12){
            esitoLancio = lancio(numDadi);
            muovi(giocatore, esitoLancio);
        }
        verificaPremio(giocatore, esitoLancio);


    }
}
