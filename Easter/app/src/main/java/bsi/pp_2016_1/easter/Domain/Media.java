package bsi.pp_2016_1.easter.Domain;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;

public class Media implements Serializable {
	
	private int id;
	private String title;
	private String midiaCategory;
	private int imageUrl;
	private ArrayList<EasterEgg> easterEggs = new ArrayList<EasterEgg>();
	private int rate = 0;
	private ArrayList<Commentary> commentList = new ArrayList<Commentary>();

	public ArrayList<Commentary> getCommentList() {return this.commentList;}
	public void setCommentList(ArrayList<Commentary> commentList) {this.commentList = commentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getMidiaCategory() {
		return midiaCategory;
	}
	public void setMidiaCategory(String midiaCategory) {
		this.midiaCategory = midiaCategory;
	}

	public int getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(int imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ArrayList<EasterEgg> getEasterEggs() {
		return easterEggs;
	}
	public void setEasterEggs(ArrayList<EasterEgg> easterEggs) {
		this.easterEggs = easterEggs;
        this.calcAndSetRate();
	}
	
	public void addEasterEgg(EasterEgg easterEgg){
		this.easterEggs.add(easterEgg);
        this.calcAndSetRate();
	}
	
	public void removeEasterEgg(EasterEgg easterEgg){
		this.easterEggs.remove(easterEgg);
        this.calcAndSetRate();
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void addCommentary(Commentary c) {
		this.commentList.add(c);
	}

	public void calcAndSetRate() {
        int sumEasterEggsRate = 0;
        int divider = this.easterEggs.size();
        for (EasterEgg ea : this.easterEggs) {
            if (ea.getRate()>0) { sumEasterEggsRate += ea.getRate(); }
            else { divider -= 1; }
        }
        if (divider>0) {
            int mediaRate = round(sumEasterEggsRate/divider);
            this.setRate(mediaRate);
        }
	}

}
