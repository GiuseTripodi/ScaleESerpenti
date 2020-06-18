package test;

import GiocoEtabellone.Tabellone;
import Partite.*;
import Partite.PartitaInterfacciaRigaDiComando;

import java.io.IOException;

public class TestPartitaRigaDiComando {
    public static void main(String ... args)  {
        Partita partita = new PartitaInterfacciaRigaDiComando();
        //partita.chiediInformazioniSuPartita();
        //partita.costruisciPartitaStandard();
        //partita.partitaInterattiva();
        //partita.partitaSimulata();
        //partita.caricaSuFile("configurazioneParitta.txt");
        partita.caricaDaFile("configurazioneParitta.txt");
        partita.getTabellone().stampa();
        System.out.println("-----------------------------");




    }
}
