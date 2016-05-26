package bsi.pp_2016_1.easter.Domain;
import java.util.ArrayList;
import java.util.Date;

public class Comentary {

    private int id;
    private String text;
    private Date date;
    private String userName;
    private int userPic;
    private int rate;
//  private int qtdLikes;
//  private int qtdDislikes;
//  private ArrayList<ComentaryAvaliation> avaliations;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getRate() { return rate; }

    public void setRate(int rate) { this.rate = rate; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPic() {
        return userPic;
    }

    public void setUserPic(int userPic) {
        this.userPic = userPic;
    }


}
