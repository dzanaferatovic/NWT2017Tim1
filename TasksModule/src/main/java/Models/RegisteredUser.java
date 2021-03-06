package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String username;
	private Boolean administratorPrivileges;
	
	@OneToMany(mappedBy="user", orphanRemoval=true)
	private List<Task> tasks;
	
	@OneToMany(mappedBy="user", orphanRemoval=true)
	private List<Solution> solutions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAdministratorPrivileges() {
		return administratorPrivileges;
	}

	public void setAdministratorPrivileges(Boolean administratorPrivileges) {
		this.administratorPrivileges = administratorPrivileges;
	}
	
	@JsonIgnore
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@JsonIgnore
	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public RegisteredUser() {}

}

