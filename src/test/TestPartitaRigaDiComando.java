package test;

import GiocoEtabellone.Tabellone;
import Partite.*;
import Partite.PartitaInterfacciaRigaDiComando;

public class TestPartitaRigaDiComando {
    public static void main(String ... args){
        Partita partita = new PartitaInterfacciaRigaDiComando();
        partita.chiediInformazioniSuPartita();
        partita.getTabellone().stampa();
        partita.partitaInterattiva();



    }
}
