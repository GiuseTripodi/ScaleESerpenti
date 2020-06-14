package test;

import SupportClass.Posizione;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testPosizioneJunit {
    int numeroCelleTabellone = 19;
    int numeroRigheTabellone  = 4;
    int numeroColonneTabellone = 5;

    @Test
    public void test(){
        Posizione p = new Posizione();
        p.setInformazioniTabellone(numeroRigheTabellone, numeroColonneTabellone, numeroCelleTabellone);
        p.setNumeroCella(4);assertEquals(4, p.getNumeroCella());
        System.out.println("-----------------------");
        Posizione p2 = p.copy();
        p2.setNumeroCella(14);assertEquals(14, p2.getNumeroCella());

        assertFalse(p.posizioneSuccessiva(p2));
        System.out.println("-----------------------");
        int esitoLancio = 4;

        p2.posDopoLancio(esitoLancio);assertEquals(18, p2.getNumeroCella());



    }
}
