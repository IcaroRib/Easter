package Domain;
import java.util.ArrayList;
import java.util.Date;

public class Comentary {

    private int id;
    private String text;
    private Date date;
    private int qtdLikes;
    private int qtdDislikes;
    private ArrayList<ComentaryAvaliation> avaliations;

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
    public int getQtdLikes() {
        return qtdLikes;
    }
    public void setQtdLikes(int qtdLikes) {
        this.qtdLikes = qtdLikes;
    }
    public int getQtdDislikes() {
        return qtdDislikes;
    }
    public void setQtdDislikes(int qtdDislikes) {
        this.qtdDislikes = qtdDislikes;
    }

    public ArrayList<ComentaryAvaliation> getAvaliations() {
        return avaliations;
    }
    public void setAvaliations(ArrayList<ComentaryAvaliation> avaliations) {
        this.avaliations = avaliations;

    }

    public void addAvaliation(ComentaryAvaliation newAvaliation){
        this.avaliations.add(newAvaliation);
        if(newAvaliation.getAvaliation() == true){
            this.sumLike();
        }

        else{
            this.sumDislike();
        }
    }

    public void removeAvaliation(ComentaryAvaliation newAvaliation){
        this.avaliations.remove(newAvaliation);
        if(newAvaliation.getAvaliation() == true){
            this.subtractLike();
        }

        else{
            this.subtractDislike();
        }

    }

    public ComentaryAvaliation searchAvaliationByIdUser(ComentaryAvaliation newAvaliation){
        for (ComentaryAvaliation oldAvaliation : this.avaliations) {
            if(oldAvaliation.getIdUser() == newAvaliation.getIdUser() && oldAvaliation.getAvaliation() != newAvaliation.getAvaliation()){
                return oldAvaliation;
            }
        }

        return null;
    }

    private void subtractDislike(){
        this.qtdDislikes -=1;
    }

    private void subtractLike(){
        this.qtdLikes -=1;
    }

    private void sumLike(){
        this.qtdLikes +=1;
    }

    private void sumDislike(){
        this.qtdDislikes +=1;
    }

    private void atualizeAvaliations(ComentaryAvaliation newAvaliation) {

        if(newAvaliation.getAvaliation() == true){
            this.sumLike();
            this.subtractDislike();
        }
        else{
            this.sumDislike();
            this.subtractLike();
        }
    }

    public void avaliete(ComentaryAvaliation newAvaliation){

        ComentaryAvaliation oldAvaliation = this.searchAvaliationByIdUser(newAvaliation);
        if(oldAvaliation != null){
            oldAvaliation = newAvaliation;
            this.atualizeAvaliations(oldAvaliation);
        }
        else{
            this.addAvaliation(newAvaliation);
        }
    }
}
