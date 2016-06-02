package bsi.pp_2016_1.easter.Domain;
import java.util.ArrayList;

public class User {

	private String acessToken;
	private String profileName;
	private String userName;
	private String password;
	private String email;
	private int id;
	private int userImage;
	private String imageUrl;
	private ArrayList<Media> favoritedMedias = new ArrayList<Media>();
	private ArrayList<EasterEgg> publishedEasterEggs = new ArrayList<EasterEgg>();

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

	public int getUserImage() {	return userImage;}

	public void setUserImage(int userImage) {this.userImage = userImage;}

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
		int mediaIndex = this.favoritedMedias.indexOf(media);
		if (mediaIndex == -1) {
			this.favoritedMedias.add(media);
		}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcessToken() {
		return acessToken;
	}

	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
