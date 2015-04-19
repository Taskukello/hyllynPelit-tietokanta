package HyllynPelit;

/**
 * Tämän luokan tehtävä on tallentaa itseensä dataa Jota ei muuten (minu
 * tietääkseni) voi kuljettaa esimerkiksi seuraavaa sivua valittaessa
 * esimerkiksi yksittäisen pelin kommenttien näyttämiseen.
 */
public class UudelleenOhjaus {

    private String atribuutti;
    private int sivunumero;
    private int suurinSivuNumero;

    public UudelleenOhjaus(String atribuutti) {
        this.atribuutti = atribuutti;
    }
    
    public UudelleenOhjaus(String atribuutti, int sivu) {
        this.atribuutti = atribuutti;
        this.sivunumero = sivu;
    }

    public int getSivunumero() {
        return sivunumero;
    }

    public void setSivunumero(int sivunumero) {
        this.sivunumero = sivunumero;
    }

    public int getSuurinSivuNumero() {
        return suurinSivuNumero;
    }

    public void setSuurinSivuNumero(int suurinSivuNumero) {
        this.suurinSivuNumero = suurinSivuNumero;
    }

    public String getAtribuutti() {
        return atribuutti;
    }

    public void setAtribuutti(String atribuutti) {
        this.atribuutti = atribuutti;
    }

}
