package test;


import SupportClass.Posizione;

public class testPosizione {
    public static void main(String... args){
        int numeroCelleTabellone = 19;
        int numeroRigheTabellone  = 4;
        int numeroColonneTabellone = 5;

        Posizione p = new Posizione();
        p.setInformazioniTabellone(numeroRigheTabellone, numeroColonneTabellone, numeroCelleTabellone);
        p.setNumeroCella(4);System.out.println(p);
        p.setNumeroCella(5);System.out.println(p);
        p.setNumeroCella(12);System.out.println(p);
        p.setNumeroCella(18);System.out.println(p);
        System.out.println("-----------------------");
        Posizione p2 = p.copy();
        p2.setNumeroCella(19);System.out.println(p2);

        System.out.println(p.posizioneSuccessiva(p2));

        int esitoLancio = 4;
        System.out.println("-----------------------");
        p2.posDopoLancio(esitoLancio);System.out.println(p2);





    }
}
