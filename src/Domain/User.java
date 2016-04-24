package Domain;
import java.util.ArrayList;

public class User {
	
	private String profileName;
	private String userName;
	private int id;
	private ArrayList<Midia> favoritedMidias;
	private ArrayList<EasterEgg> publishedEasterEggs;
	
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<EasterEgg> getPublishedEasterEggs() {
		return publishedEasterEggs;
	}
	public void setPublishedEasterEggs(ArrayList<EasterEgg> publishedEasterEggs) {
		this.publishedEasterEggs = publishedEasterEggs;
	}
	public ArrayList<Midia> getFavoritedMidias() {
		return favoritedMidias;
	}
	public void setFavoritedMidias(ArrayList<Midia> favoritedMidias) {
		this.favoritedMidias = favoritedMidias;
	}
	
	public void addFavoritedMidia(Midia midia){
		this.favoritedMidias.add(midia);
	}
	
	public void removeFavoritedMidia(Midia midia){
		this.favoritedMidias.remove(midia);
	}
	
	public void addPublishedEasterEgg(EasterEgg easterEgg){
		this.publishedEasterEggs.add(easterEgg);
	}
	
	public void removePublishedEasterEgg(EasterEgg easterEgg){
		this.publishedEasterEggs.remove(easterEgg);		
	}

}
