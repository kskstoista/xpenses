package gyakorlas.penz;

/**
 * Created by Kzfot on 2018. 02. 14..
 */

public class Lista_konstans {

    private int forint;
    private String definicio;

    public Lista_konstans(int forint, String definicio) {
        this.forint = forint;
        this.definicio = definicio;
    }

    public int getForint() {
        return forint;
    }

    public String getDefinicio() {
        return definicio;
    }

    public void setForint(int forint) {
        this.forint = forint;
    }

    public void setDefinicio(String definicio) {
        this.definicio = definicio;
    }
}
