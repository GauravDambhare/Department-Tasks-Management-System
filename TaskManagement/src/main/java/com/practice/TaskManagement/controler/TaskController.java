package com.practice.TaskManagement.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.TaskManagement.entity.Task;
import com.practice.TaskManagement.service.TaskService;

@Controller
@RequestMapping
public class TaskController {

	@Autowired
	TaskService service;

	@GetMapping("showHomePage")
	public String showHomePage() {

		return "homePage";

	}

	@GetMapping("showCreatePage")
	public String showCreatePage() {

		return "createPage";

	}

	@GetMapping("showDeleteTaskPage")
	public String showDeleteTaskPage() {

		return "deleteTaskPage";

	}

	@GetMapping("showupdateStatusPage")
	public String showupdateStatusPage() {

		return "updateStatusPage";

	}

	@GetMapping("showupdateAsighntoPage")
	public String showupdateAsighntoPage() {

		return "updateAsighntoPage";

	}

	@GetMapping("showupdateRatingPage")
	public String showupdateRatingPage() {

		return "updateRatingPage";

	}

	@GetMapping("showupdateDeadLinePage")
	public String showupdateDeadLinePage() {

		return "updateDeadLinePage";

	}

	@GetMapping("showGetTaskByRatingsPage")
	public String showGetTaskByRatingsPage() {

		return "GetTaskByRatingsPage";

	}

	@GetMapping("showGetTaskByDeadLinePage")
	public String showGetTaskByDeadLinePage() {

		return "GetTaskByDeadLinePage";

	}

	@GetMapping("showGetTaskByAsighneePage")
	public String showGetTaskByAsighneePage() {

		return "GetTaskByAsighneePage";

	}

	@GetMapping("showGetTaskByStatusPage")
	public String showGetTaskByStatusPage() {

		return "GetTaskByStatusPage";

	}

	@PostMapping("createTask")
	public void createTask(@RequestBody Task task) {
		service.createTask(task);

	}

	@PostMapping("/createTask11")
	public String createTask11(@RequestParam int taskId, @RequestParam int deadLineInHours, @RequestParam int starRating,
			@RequestParam String discription, @RequestParam String status, @RequestParam String assighnTo) {

		Task task = new Task(taskId, deadLineInHours, starRating, discription, status, assighnTo);
		service.createTask(task);
		
		
		return "taskAddDonePage" ;
	}

	@PostMapping("deleteTask")
	public String deleteTask(@RequestParam("taskId") int id , Model model) {
		
	String Message= null; 
	 int deleteTask = service.deleteTask(id);
	 if (deleteTask==0) {
		 Message = "Invalid ID please enter valid Id" ;
	 }else if (deleteTask==1) {
		 Message = "Task Delete Sucsessfully" ; 
	 }
	 model.addAttribute("Message", Message);
	  return "taskDeleteDonePage";
	}

	@GetMapping("showAllTasks")
	public String showAllTasks(Model model) {
		List<Task> allTasks = service.showAllTasks();
		model.addAttribute("tasks", allTasks);
		return "showAllTasksPage";
	}

	@PostMapping("updateStatus")
	public String updateStatus(@RequestParam("taskId") int id, @RequestParam("status") String newstatus , Model model) {
        String Message = null ;
		int updateStatus = service.updateStatus(id, newstatus);
		if (updateStatus==0) {
			 Message = "Invalid ID please enter valid Id" ;
		 }else if (updateStatus==1) {
			 Message = "Task Updated Sucsessfully" ; 
		 }
		 model.addAttribute("Message", Message);
		return "statusUpdateDonePage" ;

	}
	

	@PostMapping("updateAssighnTo")
	public String updateAssighnTo(@RequestParam("taskId") int id, @RequestParam("assignee") String newAssighne, Model model ) {
		String Message = null ;
		int updateAssighnTo = service.updateAssighnTo(id, newAssighne);
		if (updateAssighnTo==0) {
			 Message = "Invalid ID please enter valid Id" ;
		 }else if (updateAssighnTo==1) {
			 Message = "Assignee Updated Sucsessfully" ; 
		 }
		 model.addAttribute("Message", Message);
		
		return "AssighnToUpdateDonePage" ;

	}
	

	@PostMapping("updateRating")
	public String updateRating(@RequestParam("taskId") int id, @RequestParam("rating") int newRating, Model model) {
		String Message = null ;
		int updateRating = service.updateRating(id, newRating);
		if (updateRating==0) {
			 Message = "Invalid ID please enter valid Id" ;
		 }else if (updateRating==1) {
			 Message = "Assignee Updated Sucsessfully" ; 
		 }
		 model.addAttribute("Message", Message);
		return "ratingsUpdateDonePage" ;

	}
	

	@PostMapping("updateDeadLine")
	public String updateDeadLine(@RequestParam("taskId") int id, @RequestParam("deadlineInHours") int newDeadLine, Model model) {
		String Message = null ;
		int updateDeadLine = service.updateDeadLine(id, newDeadLine);
		if (updateDeadLine==0) {
			 Message = "Invalid ID please enter valid Id" ;
		 }else if (updateDeadLine==1) {
			 Message = "DeadLine Updated Sucsessfully" ; 
		 }
		 model.addAttribute("Message", Message);
		
		return "deadLineUpdateDonePage" ;
	}
	
	

	@PostMapping("getTaskByRatings")
	public String getTaskByRatings(@RequestParam("ratings") int ratings , Model model) {

		List<Task> taskByRatings = service.getTaskByRatings(ratings);
		model.addAttribute("tasks", taskByRatings);

		return "taskByRatings";

	}

	@PostMapping("/getTasksByDeadline")
	public String getTasksByDeadline(@RequestParam("deadlineInHours") int deadlineInHours, Model model) {

		List<Task> taskByDeadLine = service.getTaskByDeadLine(deadlineInHours);
		model.addAttribute("tasks", taskByDeadLine);
		
		return "taskByDeadLine";

	}

	@PostMapping("/getTaskByStatus")
	public String getTaskByStatus(@RequestParam("status") String status , Model model) {

		List<Task> taskByStatus = service.getTaskByStatus(status);
		model.addAttribute("tasks", taskByStatus);
		return "getTaskByStatus";

	}

	@PostMapping("getTaskByAssingsPerson")
	public String getTaskByAssingsPerson(@RequestParam("assigneeName") String assighnTo , Model model ) {

		List<Task> taskByAssingsPerson = service.getTaskByAssingsPerson(assighnTo);
		
		model.addAttribute("tasks", taskByAssingsPerson);

		return "taskByAssingsPerson";

	}

}
