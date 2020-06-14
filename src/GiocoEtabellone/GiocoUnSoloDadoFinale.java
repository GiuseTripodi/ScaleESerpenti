package GiocoEtabellone;

import Giocatore.Giocatore;

public class GiocoUnSoloDadoFinale extends AbstractGioco {
    private final int numDadiStandard = 2;
    private final int numDadiUltimeCelle = 1;

    public GiocoUnSoloDadoFinale(Tabellone tabellone){
        super(tabellone);
    }

    @Override
    public void mossa(Giocatore giocatore) {
        rimuoviDaUltimaCella(giocatore);
        //verifico la posizione in cui si troca il giocatore
        int numeroCelleTabellone = tabellone.getNumeroCelle();
        int cellaGiocatore = giocatore.getPosizione().getNumeroCella();
        int esitoLancio = 0;
        if(cellaGiocatore > numeroCelleTabellone - 7 && cellaGiocatore < numeroCelleTabellone -1)
            esitoLancio = lancio(numDadiUltimeCelle);
        else
            esitoLancio = lancio(numDadiStandard);
        muovi(giocatore, esitoLancio);
        verificaPremio(giocatore, esitoLancio);

    }
}
