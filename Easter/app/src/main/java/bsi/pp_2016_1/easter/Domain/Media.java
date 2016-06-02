package bsi.pp_2016_1.easter.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Media implements Serializable {
	
	private int id;
	private String title;
	private String midiaCategory;
	private int imageUrl;
	private ArrayList<EasterEgg> easterEggs;
	private int rate;
	private ArrayList<Commentary> commentList;

	public ArrayList<Commentary> getCommentList() {return commentList;}
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
	}
	
	public void addEasterEgg(EasterEgg easterEgg){
		this.easterEggs.add(easterEgg);
	}
	
	public void removeEasterEgg(EasterEgg easterEgg){
		this.easterEggs.remove(easterEgg);
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
