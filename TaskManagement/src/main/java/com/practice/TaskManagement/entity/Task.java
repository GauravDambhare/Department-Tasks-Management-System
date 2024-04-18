package com.practice.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	int taskId;
	int deadLineInHours;
	int starRating;
	String discription;
	String status;
	String assighnTo;

	public Task() {
		super();
	}

	public Task(int taskId, int deadLineInHours, int starRating, String discription, String status, String assighnTo) {
		super();
		this.taskId = taskId;
		this.deadLineInHours = deadLineInHours;
		this.starRating = starRating;
		this.discription = discription;
		this.status = status;
		this.assighnTo = assighnTo;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getDeadLineInHours() {
		return deadLineInHours;
	}

	public void setDeadLineInHours(int deadLineInHours) {
		this.deadLineInHours = deadLineInHours;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssighnTo() {
		return assighnTo;
	}

	public void setAssighnTo(String assighnTo) {
		this.assighnTo = assighnTo;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", deadLineInHours=" + deadLineInHours + ", starRating=" + starRating
				+ ", discription=" + discription + ", status=" + status + ", assighnTo=" + assighnTo + "]";
	}

}
