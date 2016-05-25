package bsi.pp_2016_1.easter.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class EasterEgg implements Serializable {

    private int id;
    private String description;
    private String title;
    private double progressStatus;
    private int creatorId;
    private String creatorName;
    private int rate;
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

	public double getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(double progressStatus) {
		this.progressStatus = progressStatus;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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
