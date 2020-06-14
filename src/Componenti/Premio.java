package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class Premio  extends AbstractComponent{
    public enum TipoPremio {DADI, MOLLA}; //renderlo privato per il rilascio finale
    private TipoPremio tipoPremio;

    public Premio(Posizione p, TipoPremio tipoPremio){
        super(p);
        this.tipoPremio = tipoPremio;
    }

    @Override
    public void stampa() {
        if(getGiocatore() != null)
            System.out.print(String.format("[ Pr[%d]mi ]", getGiocatore().getID()));
        System.out.print("[  Premi  ]");
    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
        g.assegnaPremio(this);

    }

    public TipoPremio getTipoPremio() {
        return tipoPremio;
    }
}
