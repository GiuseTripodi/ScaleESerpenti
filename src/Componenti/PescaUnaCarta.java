package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

import java.util.LinkedList;
import java.util.Random;

public class PescaUnaCarta extends AbstractComponent {
    /**
     * Il primo nodo corrisponde alla prima carta del mazzo, l'ultimo
     * all'ultima carta
     */
    private LinkedList<AbstractComponent> mazzo;
    private int numeroCarteMazzo;
    Random r ;
    private Posizione posizioneFittizia;

    public PescaUnaCarta(Posizione posizione, int numeroDiCarteNelMazzo){
        super(posizione);
        this.numeroCarteMazzo = numeroDiCarteNelMazzo;
        mazzo = new LinkedList<>();
        r = new Random();
        posizioneFittizia = new Posizione(0,0,0); //posizione nulla di default
        //Riempio il mazzo, non casualmente
        for(int i = 0; i< numeroDiCarteNelMazzo; i++){
            Float random = r.nextFloat();
            if(random < 0.25)mazzo.add(new Premio(posizioneFittizia, Premio.TipoPremio.DADI));
            if(random >= 0.25 && random < 0.50)mazzo.add(new Sosta(posizioneFittizia, Sosta.TipoSosta.LOCANDA));
            if(random >= 0.50 && random < 0.75)mazzo.add(new Sosta(posizioneFittizia, Sosta.TipoSosta.PANCHINA));
            if(random >= 0.75 && random < 1)mazzo.add(new Premio(posizioneFittizia, Premio.TipoPremio.MOLLA));
        }
    }//Costruttore

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
        //Pesca una carta
         AbstractComponent cartaPescata = mazzo.getFirst(); // pesco la prima carta del mazzo
         cartaPescata.azione(g);
         mazzo.addLast(cartaPescata); //aggiungo la carta infondo al mazzo
    }

    /**
     * Il metodo implemta il requisito UlterioriCarte, quindi aggiunge nel mazzo
     * alcune carte di tipo Divieto di sosta
     */
    public void ulterioriCarte(int numeroCarteDivietoDiSosta){
        for(int i = 0; i< numeroCarteDivietoDiSosta ; i++){
            Float percentuale = r.nextFloat();
            if(percentuale <= 0.1){
                int index = r.nextInt(numeroCarteMazzo);
                mazzo.set(index, new DivietoDiSosta(posizioneFittizia));
            }
        }


    }

    @Override
    public void stampa() {
        if(this.getGiocatore() != null)
            System.out.print(String.format("[ Pe[%d]Ca ]", this.getGiocatore().getID()));
        System.out.print("[  PesCa  ]");
    }
}
