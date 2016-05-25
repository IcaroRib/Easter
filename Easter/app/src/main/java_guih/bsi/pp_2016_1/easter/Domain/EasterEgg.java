package bsi.pp_2016_1.easter.Domain;
import java.util.ArrayList;

public class EasterEgg {
	
	private int id;
	private String description;
	private String imageUrl;
	private double progressStatus;
	private int creatorId;
	private String creatorName;
	private ArrayList<Task> taskList;
	private ArrayList<Reference> referenceList;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(double progressStatus) {
		this.progressStatus = progressStatus;
	}

	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public ArrayList<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	public ArrayList<Reference> getReferenceList() {
		return referenceList;
	}
	public void setReferenceList(ArrayList<Reference> referenceList) {
		this.referenceList = referenceList;
	}

}
