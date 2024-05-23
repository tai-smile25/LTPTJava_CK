package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "department_id")
	private String id;
	private String name;
	private String location;

	public Department() {
		super();
	}

	public Department(String id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	
	

}
