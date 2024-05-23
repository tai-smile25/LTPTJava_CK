package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor extends Person implements Serializable{
	private static final long serialVersionUID = 1L;

	private String speciality;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	public Doctor() {
		super();
	}

	public Doctor(String id, String name, String phone, String speciality, Department department) {
		super(id, name, phone);
		this.speciality = speciality;
		this.department = department;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", department=" + department + "]";
	}

}
