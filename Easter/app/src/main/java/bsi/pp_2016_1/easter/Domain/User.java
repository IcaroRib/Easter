package bsi.pp_2016_1.easter.Domain;
import java.util.ArrayList;

public class User {
	
	private String profileName;
	private String userName;
	private int id;
	private ArrayList<Media> favoritedMedias;
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

	public ArrayList<Media> getFavoritedMedias() {
		return favoritedMedias;
	}

	public void setFavoritedMedias(ArrayList<Media> favoritedMedias) {
		this.favoritedMedias = favoritedMedias;
	}

	public void addFavoritedMidia(Media media) {
		this.favoritedMedias.add(media);
	}

	public void removeFavoritedMidia(Media media) {
		this.favoritedMedias.remove(media);
	}
	
	public void addPublishedEasterEgg(EasterEgg easterEgg){
		this.publishedEasterEggs.add(easterEgg);
	}
	
	public void removePublishedEasterEgg(EasterEgg easterEgg){
		this.publishedEasterEggs.remove(easterEgg);		
	}

}
