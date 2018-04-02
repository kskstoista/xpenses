package gyakorlas.penz;

import java.util.Arrays;

public class Tranzakcio {

    public static final boolean BEVETEL = true;
    public static final boolean KIADAS = false;
    private Boolean tipus;
    private String megjegy;
    private String kategoria;
    private String datum;
    private int osszeg;

    public Tranzakcio(Boolean tipus, String megjegyzes, String spinerEredmeny, String datum, int osszeg) {
        this.tipus = tipus;
        this.megjegy = megjegyzes;
        this.kategoria = spinerEredmeny;
        this.datum = datum;
        this.osszeg = osszeg;
    }

    public Tranzakcio(String tranzakcioRekord) {

        String[] elements = tranzakcioRekord.split(":");
        if (elements[0].equals("true")) {
            this.tipus = true;
        } else {
            this.tipus = false;
        }
        this.megjegy = elements[1];
        this.kategoria = elements[2];
        this.datum = elements[3];
        this.osszeg = Integer.parseInt(elements[4]);
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
}





