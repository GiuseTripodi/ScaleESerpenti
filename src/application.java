import Componenti.SerpenteInizio;
import Partite.Partita;
import Partite.PartitaInterfacciaRigaDiComando;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class application {
    public static void main(String ...args){
        Partita partita = new PartitaInterfacciaRigaDiComando();
        Scanner scanner  = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("*****         Benvenuto          *****");
        System.out.println("**************************************");
        System.out.println("*****       Inizia a giocare      ****");
        System.out.println("**************************************");
        System.out.println("Scegli la configurazione:");
        System.out.println("1. Inserisci i parametri della partita");
        System.out.println("2. Scegli una configurazione standard ");
        System.out.println("3. Carica i parametri da file");
        int scelta = Integer.parseInt(scanner.nextLine().trim());
        switch (scelta){
            case 1: {
                partita.chiediInformazioniSuPartita();
                System.out.println("Vuoi memorizzare la configurazione? [Y/N]");
                String ins = scanner.nextLine().trim().toUpperCase();
                if (ins.equals("Y")) {
                    System.out.println("Inserisci il nome del file da cui memorizzare la configurazione");
                    String nomeFile = scanner.nextLine().trim();
                    try {
                        partita.caricaSuFile(nomeFile);
                    } catch (IOException e) {
                        System.out.println("Problemi con il salvataggio");
                        System.exit(1);

                    }
                }
                break;
            }
            case 2: {
                partita.costruisciPartitaStandard();
                break;
            }
            case 3: {
                System.out.println("Inserisci il nome del file da cui caricare la configurazione");
                String nomeFile = scanner.nextLine().trim();
               try{
                   partita.caricaDaFile(nomeFile);
               }catch (FileNotFoundException e){
                System.out.println("File inesistente, inserire un file esistente");
                System.exit(1);
            }
                break;
            }
            default: {
                System.out.println("Il valore inserito non è corretto");
                System.exit(1);
                break;
            }
        }//switch

        System.out.println("Scegli la modalità di gioco:");
        System.out.println("1. Modalità interattiva");
        System.out.println("2. Modalità simulata ");
        int mod = scanner.nextInt();
        switch (mod){
            case 1: {
                partita.partitaInterattiva();
                break;
            }
            case 2: {
                partita.partitaSimulata();
                break;
            }
            default: {
                System.out.println("Il valore inserito non è corretto");
                System.exit(1);
                break;
            }

        }
    }//main
}//application
