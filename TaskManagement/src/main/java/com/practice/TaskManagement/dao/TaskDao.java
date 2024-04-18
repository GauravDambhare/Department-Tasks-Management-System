package com.practice.TaskManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.TaskManagement.entity.Task;

@Repository
public class TaskDao {

	@Autowired
	SessionFactory sessionFactory;

	public void createTask(Task task) {

		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(task);
		beginTransaction.commit();
	}

	public int deleteTask(int id) {
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Task task = openSession.get(Task.class, id);
		if(task == null) {
			return 0 ;
		}else {
		openSession.delete(task);}
		beginTransaction.commit();
        return 1 ;
	}

	public List showAllTasks() {

		Session openSession = sessionFactory.openSession();
		Query createQuery = openSession.createQuery("from Task");
		List list = createQuery.list();
		return list;

	}

	public int updateStatus(int id, String newstatus) {

		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Task task = openSession.get(Task.class, id);
		if (task == null) {
			return 0;
		}else {
		task.setStatus(newstatus);
		beginTransaction.commit();
		return 1 ;
		}

	}
	
	public int updateAssighnTo(int id, String newAssighne) {

		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Task task = openSession.get(Task.class, id);
		if (task == null) {
			return 0 ;
		}else {
		task.setAssighnTo(newAssighne);
		beginTransaction.commit();
		return 1 ;
		}
	}
	
	
	public int updateRating(int id, int newRating ) {

		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Task task = openSession.get(Task.class, id);
		if (task == null) {
			return 0 ;
		}else {
		task.setStarRating(newRating);
		beginTransaction.commit();
		return 1 ;
		}

	}
	
	public int updateDeadLine(int id, int newDeadLine ) {

		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Task task = openSession.get(Task.class, id);
		if (task == null) {
			return 0 ;
		}else {
		
		task.setDeadLineInHours(newDeadLine);
		beginTransaction.commit();
       return 1 ; }
	}
	
	
	public List<Task> getTaskByRatings (int starRating) {
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query<Task> createQuery = openSession.createQuery("from Task where starRating = :starRating", Task.class);
		createQuery.setParameter("starRating", starRating);
		List<Task> list = createQuery.list();
		beginTransaction.commit();
		return list ;
	}
	
	public List<Task> getTaskByDeadLine (int deadLineInHours) {
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query<Task> createQuery = openSession.createQuery("from Task where deadLineInHours = :deadLineInHours", Task.class);
		createQuery.setParameter("deadLineInHours", deadLineInHours);
		List<Task> list = createQuery.list();
		beginTransaction.commit();
		return list ;
	}

	
	
	public List<Task> getTaskByStatus (String status) {
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query<Task> createQuery = openSession.createQuery("from Task where status = :status", Task.class);
		createQuery.setParameter("status", status);
		List<Task> list = createQuery.list();
		beginTransaction.commit();
		return list ;
	}
	
	public List<Task> getTaskByAssingsPerson (String assighnTo) {
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query<Task> createQuery = openSession.createQuery("from Task where assighnTo = :assighnTo", Task.class);
		createQuery.setParameter("assighnTo", assighnTo);
		List<Task> list = createQuery.list();
		beginTransaction.commit();
		return list ;
	}
}
