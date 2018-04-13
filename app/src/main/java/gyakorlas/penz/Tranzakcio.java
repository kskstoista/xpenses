package gyakorlas.penz;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Tranzakcio {

    public static final boolean BEVETEL = true;
    public static final boolean KIADAS = false;

    @PrimaryKey
    int id;
    private Boolean tipus;
    private String megjegy;
    private String kategoria;
    private String datum;
    private int osszeg;

    public Tranzakcio(){

    }

    public Tranzakcio(int sorszam, Boolean tipus, String megjegyzes, String spinerEredmeny, String datum, int osszeg) {
        this.id = sorszam;
        this.tipus = tipus;
        this.megjegy = megjegyzes;
        this.kategoria = spinerEredmeny;
        this.datum = datum;
        this.osszeg = osszeg;
    }

    public String toString() {

        return this.tipus + ":" + this.megjegy + ":" + this.kategoria + ":" + this.datum + ":" + this.osszeg+"\n";
    }

    public Boolean getTipus() {
        return tipus;
    }

    public String getMegjegy() {
        return megjegy;
    }
    public String getKategoria() {
        return kategoria;
    }
    public String getDatum(){
        return datum;
    }
    public int getOsszeg() {
        return osszeg;
    }

    public void setTipus(Boolean tipus) {
        this.tipus = tipus;
    }

    public void setMegjegyzes(String megjegy) {
        this.megjegy = megjegy;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setMegjegy(String megjegy) {
        this.megjegy = megjegy;
    }
}





