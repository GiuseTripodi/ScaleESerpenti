package test;

import java.util.Scanner;

public class TestScanne {
    public static void main(String ... args){
        int numGiocatoriStandard;
        int numDadiStandard;
        int nR ;
        int nC ;
        int nCelle ;
        int nScale ;
        int nSoste;
        int nSerpenti;
        int nPremi ;
        int nPesca ;
        int nPescaUlteriori;

        int codiceDelTipoDiGioco;

        Scanner scanner = new Scanner(System.in);
        //chiedo le informazioni
        System.out.println("*********************************");
        System.out.println("*      Scale e Serpenti         *");
        System.out.println("*********************************");
        //chiedo le informazioni sul tabellone
        System.out.println("------------------------------------------------");
        System.out.println("-----Sceglio il tipo di gioco-----\n" +
                            "Inserisci il numero corrispondente al gioco \n" +
                "1. Gioco Normale \n" +
                "2. Gioco con impostazione doppio sei \n" +
                "3. Gioco con un solo dado nelle mosse finali");
        codiceDelTipoDiGioco = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("------------------------------------------------");
        System.out.println("----Inserisci le impostazioni del tabellone----");
        System.out.println("Inserisci il numero di righe:");
        nR = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di colonne:");
        nC = Integer.parseInt(scanner.nextLine().trim());
        //costruisco il numero di celle
        nCelle = nC * nR;
        System.out.println("Inserisci il numero di scale che vuoi inserire:");
        nScale = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di Serpenti che vuoi inserire:");
        nSerpenti = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle di sosta che vuoi inserire:");
        nSoste = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle con premi che vuoi inserire:");
        nPremi = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle pesca una carta che vuoi inserire:");
        nPesca = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle pesca una carta con ulteriori carte che vuoi inserire:");
        nPescaUlteriori = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("------------------------------------------------");
        System.out.println("Inserisci il numero di giocatori che possono partecipare la gioco");
        numGiocatoriStandard = Integer.parseInt(scanner.nextLine().trim());



    }
}
