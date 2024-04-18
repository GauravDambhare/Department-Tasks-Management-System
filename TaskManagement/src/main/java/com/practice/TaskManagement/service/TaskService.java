package com.practice.TaskManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.TaskManagement.dao.TaskDao;
import com.practice.TaskManagement.entity.Task;

@Service
public class TaskService {

	@Autowired
	TaskDao dao;

	public void createTask(Task task) {

		dao.createTask(task);
	}

	public int deleteTask(int id) {

		int deleteTask = dao.deleteTask(id);
		
		return deleteTask ;

	}

	public List showAllTasks() {

		List showAllTasks = dao.showAllTasks();

		return showAllTasks;
	}

	public int updateStatus(int id, String newstatus) {

		int updateStatus = dao.updateStatus(id, newstatus);
		
		return updateStatus ;
		
	}

	public int updateAssighnTo(int id, String newAssighne) {

		int updateAssighnTo = dao.updateAssighnTo(id, newAssighne);
		
		return updateAssighnTo ;
	}

	public int updateRating(int id, int newRating) {

		int updateRating = dao.updateRating(id, newRating);
		return updateRating ;
	}

	public int updateDeadLine(int id, int newDeadLine) {

		int updateDeadLine = dao.updateDeadLine(id, newDeadLine);
		return updateDeadLine ;

	}

	public List<Task> getTaskByRatings(int ratings) {

		List<Task> taskByRatings = dao.getTaskByRatings(ratings);
		return taskByRatings;

	}

	public List<Task> getTaskByDeadLine(int deadLineInHours) {

		List<Task> taskByDeadLine = dao.getTaskByDeadLine(deadLineInHours);
		return taskByDeadLine;

	}

	public List<Task> getTaskByStatus(String status) {

		List<Task> taskByStatus = dao.getTaskByStatus(status);
		return taskByStatus;

	}

	public List<Task> getTaskByAssingsPerson(String assighnTo) {

		List<Task> taskByAssingsPerson = dao.getTaskByAssingsPerson(assighnTo);
		return taskByAssingsPerson;

	}

}
