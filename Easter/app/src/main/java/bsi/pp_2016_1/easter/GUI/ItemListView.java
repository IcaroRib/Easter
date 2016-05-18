package bsi.pp_2016_1.easter.GUI;

import android.widget.RatingBar;

/**
 * Created by franc on 01/05/2016.
 */
public class ItemListView {
    private String texto;
    private int iconeRid;

    private RatingBar rate;

    public ItemListView(String s, int biff, RatingBar rate) {
        this.texto = s;
        this.iconeRid = biff;
        this.rate = rate;
    }


    public ItemListView(String texto, int iconeRid) {
        this.texto = texto;
        this.iconeRid = iconeRid;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public RatingBar getRate() {
        return rate;
    }

    public void setRate(RatingBar rate) {
        this.rate = rate;
    }
}
