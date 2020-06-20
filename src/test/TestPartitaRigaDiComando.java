package test;

import GiocoEtabellone.Tabellone;
import Partite.*;
import Partite.PartitaInterfacciaRigaDiComando;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestPartitaRigaDiComando {
    public static void main(String ... args) throws FileNotFoundException {
        Partita partita = new PartitaInterfacciaRigaDiComando();
        //partita.chiediInformazioniSuPartita();
        //partita.costruisciPartitaStandard();
        //partita.partitaInterattiva();
        //partita.partitaSimulata();
        //partita.caricaSuFile("configurazionePartita.txt");
        partita.caricaDaFile("configurazionePartita.txt");
        partita.getTabellone().stampa();
        System.out.println("-----------------------------");




    }
}
