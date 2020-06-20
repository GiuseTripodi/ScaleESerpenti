package SupportClass;

import java.util.Objects;

/**
 * Questa classe implementa il concetto di posizione all'interno del tabellone, usata esclusivamente per semplicità
 * implementativa e per aiutare in alcune funzioni.
 */
public class Posizione implements Cloneable{
    private int indiceRiga; //indice di riga
    private int indiceColonna; //indice di colonne
    private int numeroCella; //indica l'avenzamento rispetto alla prima cella del tabellone. E' numerato da 0 ad N-1(
                            //con N numero di celle(contate a partire da 1)
    private int numeroRigheTabellone;
    private int numeroColonneTabellone;
    private int numeroCelleTabellone;

    public Posizione(int numeroCella, int numeroRigheTabellone, int numeroColonneTabellone, int numeroCelleTabellone){
        this.numeroCella = numeroCella;
        this.numeroRigheTabellone = numeroRigheTabellone;
        this.numeroCelleTabellone = numeroCelleTabellone;
        this.numeroColonneTabellone = numeroColonneTabellone;
        this.indiceColonna = numeroCella % (numeroColonneTabellone);
        this.indiceRiga = numeroCella / (numeroColonneTabellone);
    }

    public Posizione(){

    }

    /**
     * Costruttore di una posizione fornendo solo il numero di cella
     * @param numCella
     */
    public Posizione(int numCella) {
        this.numeroCella = numCella;
        this.indiceColonna = numCella % (numeroColonneTabellone);
        this.indiceRiga = numCella / (numeroColonneTabellone);
    }

    public Posizione(int X, int Y, int avanzamento){
        this.indiceRiga = X;
        this.indiceColonna = Y;
        this.numeroCella = avanzamento;
    }

    /**
     * Il metodo imposta le informazioni del tabellone
     * @param numeroRigheTabellone
     * @param numeroColonneTabellone
     * @param numeroCelleTabellone
     */
    public void setInformazioniTabellone(int numeroRigheTabellone,int numeroColonneTabellone,int numeroCelleTabellone){
        this.numeroCelleTabellone = numeroCelleTabellone;
        this.numeroColonneTabellone = numeroColonneTabellone;
        this.numeroRigheTabellone = numeroRigheTabellone;
    }

    /**
     * Il metodo dato una posizione nel tabellone, un numero di cella, definisce l'opportuno indice di riga e di colonna
     * @param numCella
     */
    public void setNumeroCella(int numCella){
        if(numCella > numeroCelleTabellone)throw new IllegalArgumentException("Il numero di cella non può essere superiore al numero di celle totali del tabellone");
        this.numeroCella = numCella;
        this.indiceColonna = numCella % (numeroColonneTabellone);
        this.indiceRiga = numCella / (numeroColonneTabellone);
    }

    public int getNumeroCella(){
        return numeroCella;
    }

    public int getIndiceRiga() {
        return indiceRiga;
    }

    public int getIndiceColonna() {
        return indiceColonna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return indiceRiga == posizione.indiceRiga &&
                indiceColonna == posizione.indiceColonna &&
                numeroCella == posizione.numeroCella;
    }

    @Override
    public int hashCode() {
        return Objects.hash(indiceRiga, indiceColonna);
    }

    public String toString(){
        return String.format("Posizione in cella %d:[%d, %d]", numeroCella, indiceRiga, indiceColonna);
    }

    /**
     * Data una posizione(this) il metodo restituisce una copia di quella specifica posizione per una particolare
     * struttura del tabellone, quindi copiando i parametri del tabellone. Per indicare i parametri relatici ad una
     * specifica cella, basta inserire con il metodo setNumeroCella l'indice di una specifica cella.
     * @return una copia della posizione this
     */
    public Posizione copy(){
        Posizione ret = new Posizione();
        ret.setInformazioniTabellone(this.numeroRigheTabellone, this.numeroColonneTabellone, this.numeroCelleTabellone);
        return ret;

    }

    /**
     * Verifica se una posizione è successiva rispetto ad un altra, ovvero se viene dopo nel tabellone
     * @param p, prima posizione
     * @return true se this è successivo rispetto a p, se quindi viene dopo nel tabellone
     */
    public boolean posizioneSuccessiva(Posizione p){
        return this.numeroCella >= p.numeroCella;
    }

    /**
     * Il metodo aggiorna una posizione risultante a seguito del lancio di un dado, secondo la logica del gioco,
     * quindi se arriva alle ultime celle, si muove a ritroso, se invece arriva alla fine la posizione sarà quella
     * dell'ultima cella del tabellone.
     * @param esitoLancio
     * @return una nuova Posizione ottenuta dopo il lancio
     */
    public Posizione posDopoLancio(int esitoLancio) {
        Posizione ret = this.clone();
        int nCella = this.numeroCella + esitoLancio;
        if (nCella > this.numeroCelleTabellone -1) {
            nCella = (this.numeroCelleTabellone-1) - (nCella % (this.numeroCelleTabellone-1));
        }
        ret.setNumeroCella(nCella);
        return ret;
    }




    public int getNumeroRigheTabellone() {
        return numeroRigheTabellone;
    }

    public int getNumeroColonneTabellone() {
        return numeroColonneTabellone;
    }

    public int getNumeroCelleTabellone() {
        return numeroCelleTabellone;
    }

    public Posizione clone(){
        try {
            Posizione ret = (Posizione)super.clone();
            return ret;
        }catch (CloneNotSupportedException e){
            throw new Error(e);
        }
    }




}
