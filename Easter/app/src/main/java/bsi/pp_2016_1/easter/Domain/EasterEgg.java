package bsi.pp_2016_1.easter.Domain;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;

public class EasterEgg implements Serializable {

    private int id;
    private String description;
    private String title;
    private double progressStatus;
    private int creatorId;
    private String creatorName;
    private int rate = 0;
    private ArrayList<Task> taskList = new ArrayList<Task>();
    private ArrayList<Media> referenceList = new ArrayList<Media>();
	private ArrayList<Commentary> commentList = new ArrayList<Commentary>();


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

	public ArrayList<Media> getReferenceList() {
		return referenceList;
	}
	public void setReferenceList(ArrayList<Media> referenceList) {
		this.referenceList = referenceList;
	}

	public ArrayList<Commentary> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Commentary> commentList) {
		this.commentList = commentList;
		this.calcAndSetRate();
	}

	public void addCommentary(Commentary c) {
		this.commentList.add(c);
		this.calcAndSetRate();
	}

	public void calcAndSetRate() {
		int sumCommentariesRate = 0;
		int divider = this.commentList.size();
		for (Commentary c : this.commentList) {
			if (c.getRate()>0) { sumCommentariesRate += c.getRate(); }
			else { divider -= 1; }
		}
		if (divider>0) {
			int easterEggRate = round(sumCommentariesRate/divider);
			this.setRate(easterEggRate);
		}

	}

}
