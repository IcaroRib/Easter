package Domain;
import java.util.ArrayList;

public class Midia {
	
	private int id;
	private String title;
	private String midiaCategory;
	private String imageUrl;
	private ArrayList<EasterEgg> easterEggs;
	
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
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

}
