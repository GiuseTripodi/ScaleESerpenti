package Builder;

import Componenti.*;
import GiocoEtabellone.ConcreteTabellone;
import GiocoEtabellone.Tabellone;
import SupportClass.Posizione;

import java.util.Random;

public class ConcreteBuilder implements Builder {
    private Tabellone tabellone;
    private Random random= new Random();
    private final int maxNumeroCarteMazzo = 10;




    @Override
    public void buildTabellone(int numeroRighe, int numeroColonne, int numeroCelleTabellone) {
        tabellone = new ConcreteTabellone(numeroRighe,numeroColonne,numeroCelleTabellone); //creo il tabbellone su cui faro le aggiunte
    }

    @Override
    public void buildTabellone() {
        int numeroRigheStandard = 10;
        int numeroColonneStandard = 10;
        int numeroCelleStandard = 100;
        buildTabellone(numeroRigheStandard,numeroColonneStandard,numeroCelleStandard);

    }

    @Override
    public Tabellone getResult() {
        return tabellone;
    }

    @Override
    public void buildCaselleScale(int numeroCaselleScale) {
        for(int i = 0; i< numeroCaselleScale; i++){
            //scelgo le posizioni in modo random, mi assicuro che la posizione iniziale
            //non sia dopo quella finale
            int numCellaIniziale ;
            int numCellaFinale;
            do {
                numCellaIniziale = random.nextInt(tabellone.getNumeroCelle());
                numCellaFinale = random.nextInt(tabellone.getNumeroCelle());
            }while (numCellaIniziale > numCellaFinale);
            Posizione posizioneIniziale = new Posizione(numCellaIniziale, tabellone.getNumRighe(),tabellone.getNumColonne(),tabellone.getNumeroCelle());
            Posizione posizioneFinale = new Posizione(numCellaFinale, tabellone.getNumRighe(),tabellone.getNumColonne(),tabellone.getNumeroCelle());
            //aggiungo la scala
            buildScala(posizioneIniziale,posizioneFinale);
        }//for
    }

    @Override
    public void buildCaselleSerpenti(int numeroCaselleSerpenti) {
        for(int i = 0; i< numeroCaselleSerpenti; i++){
            //scelgo le posizioni in modo random, mi assicuro che la posizione iniziale
            //non sia dopo quella finale
            int numCellaIniziale ;
            int numCellaFinale;
            do {
                numCellaIniziale = random.nextInt(tabellone.getNumeroCelle());
                numCellaFinale = random.nextInt(tabellone.getNumeroCelle());
            }while (numCellaIniziale > numCellaFinale);
            Posizione posizioneIniziale = new Posizione(numCellaIniziale, tabellone.getNumRighe(),tabellone.getNumColonne(),tabellone.getNumeroCelle());
            Posizione posizioneFinale = new Posizione(numCellaFinale, tabellone.getNumRighe(),tabellone.getNumColonne(),tabellone.getNumeroCelle());
            //aggiungo il serpente
            buildSerpente(posizioneIniziale,posizioneFinale);
        }//for

    }

    @Override
    public void buildCaselleSosta(int numeroCaselleSoste) {
        for (int i = 0; i < numeroCaselleSoste; i++) {
            int posizioneCella = random.nextInt(tabellone.getNumeroCelle());
            Posizione posizione = new Posizione(posizioneCella, tabellone.getNumRighe(), tabellone.getNumColonne(), tabellone.getNumeroCelle());
            //aggiungo la casella
            buildCasellaSosta(posizione);
        }
    }

    @Override
    public void buildCasellePremio(int numeroCasellePremio) {
        for (int i = 0; i < numeroCasellePremio; i++) {
            int posizioneCella = random.nextInt(tabellone.getNumeroCelle());
            Posizione posizione = new Posizione(posizioneCella, tabellone.getNumRighe(), tabellone.getNumColonne(), tabellone.getNumeroCelle());
            //aggiungo la casella
            buildCasellaPremio(posizione);
        }

    }

    @Override
    public void buildCasellePescaUnaCarta(int numeroCasellePescaUnaCarta) {
        for (int i = 0; i < numeroCasellePescaUnaCarta; i++) {
            int posizioneCella = random.nextInt(tabellone.getNumeroCelle());
            Posizione posizione = new Posizione(posizioneCella, tabellone.getNumRighe(), tabellone.getNumColonne(), tabellone.getNumeroCelle());
            //aggiungo la casella
            buildCasellaPescaUnaCarta(posizione);
        }

    }

    @Override
    public void buildCasellePescaUnaCartaConUlterioriCarte(int numeroCasellePescaUnaCartaConUlterioriCarte) {
        for (int i = 0; i < numeroCasellePescaUnaCartaConUlterioriCarte; i++) {
            int posizioneCella = random.nextInt(tabellone.getNumeroCelle());
            Posizione posizione = new Posizione(posizioneCella, tabellone.getNumRighe(), tabellone.getNumColonne(), tabellone.getNumeroCelle());
            //aggiungo la casella
            buildCasellaPescaUnaCartaConUlterioriCarte(posizione);
        }

    }

    @Override
    public boolean buildScala(Posizione posizioneInizio, Posizione posizioneFine) {
        if(posizioneInizio.posizioneSuccessiva(posizioneFine))
            return false;
        //creo le scale
        ScalaFine scalaFine = new ScalaFine(posizioneFine);
        ScalaInizio scalaInizio = new ScalaInizio(posizioneInizio,scalaFine);

        boolean aggiuntaScalaInizio = tabellone.add(scalaInizio);
        boolean aggiuntaScalaFine = tabellone.add(scalaFine);;

        //controllo se le ho aggiunte entrambe
        if(aggiuntaScalaInizio == false || aggiuntaScalaFine == false){
            if(aggiuntaScalaInizio == false){
                tabellone.remove(scalaFine);
            }
            if(aggiuntaScalaFine == false){
                tabellone.remove(scalaInizio);
            }
            return false;
        }

        return true;
    }

    @Override
    public boolean buildSerpente(Posizione posizioneInizio, Posizione posizioneFine) {
        if(posizioneInizio.posizioneSuccessiva(posizioneFine))
            return false;
        SerpenteInizio serpenteInizio = new SerpenteInizio(posizioneInizio);
        SerpenteFine serpenteFine = new SerpenteFine(posizioneFine, serpenteInizio);

        boolean aggiuntaSerpenteInizio = tabellone.add(serpenteInizio);
        boolean aggiuntaSerpenteFine = tabellone.add(serpenteFine);

        //controllo se le ho aggiunte entrambe
        if(aggiuntaSerpenteFine == false || aggiuntaSerpenteFine == false) {
            if (aggiuntaSerpenteInizio == false) {
                tabellone.remove(serpenteFine);
            }
            if (aggiuntaSerpenteFine == false) {
                tabellone.remove(serpenteInizio);
            }
            return false;
        }
        return true;

    }

    @Override
    public boolean buildCasellaSosta(Posizione posizione) {
        Sosta.TipoSosta tipoSosta = null;
        //scelgo casualmente il tipo di casella sosta
        float casual = random.nextFloat();
        if(casual < 0.5) tipoSosta = Sosta.TipoSosta.LOCANDA;
        if(casual >= 0.5 && casual < 1) tipoSosta = Sosta.TipoSosta.PANCHINA;
        //creo la casella sosta
        Sosta sosta = new Sosta(posizione, tipoSosta);
        return tabellone.add(sosta);
    }

    @Override
    public boolean buildCasellaPremio(Posizione posizione) {
        Premio.TipoPremio tipoPremio = null;
        //scelgo casualmente il tipo di premio
        float casual = random.nextFloat();
        if(casual < 0.5) tipoPremio = Premio.TipoPremio.DADI;
        if(casual >= 0.5 && casual < 1) tipoPremio = Premio.TipoPremio.MOLLA;
        //creo la casella Premio
        Premio premio = new Premio(posizione, tipoPremio);
        return tabellone.add(premio);
    }

    @Override
    public boolean buildCasellaPescaUnaCarta(Posizione posizione) {
        //prendo il numero di carte
        int numCarteMazzo = random.nextInt(maxNumeroCarteMazzo) + 1;
        StateComponent pescaUnaCarta = new PescaUnaCarta(posizione,numCarteMazzo);
        return tabellone.add(pescaUnaCarta);

    }

    @Override
    public boolean buildCasellaPescaUnaCartaConUlterioriCarte(Posizione posizione) {
        //prendo il numero di carte
        int numCarteMazzo = random.nextInt(maxNumeroCarteMazzo) + 1;
        int numCarteDivietoDiSosta = random.nextInt(maxNumeroCarteMazzo) +1;
        PescaUnaCarta pescaUnaCarta = new PescaUnaCarta(posizione,numCarteMazzo);
        pescaUnaCarta.ulterioriCarte(numCarteDivietoDiSosta);
        return tabellone.add((StateComponent)pescaUnaCarta);
    }
}
