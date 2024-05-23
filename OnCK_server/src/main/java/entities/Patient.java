package entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")

@NamedQueries({
	@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
	@NamedQuery(name = "Patient.listPatients", query = 
    "SELECT p FROM Patient p JOIN Treatment t ON p.id = t.patient.id " +
    "JOIN Doctor d ON t.doctor.id = d.id " +
    "WHERE d.speciality = :speciality " +
    "AND MONTH(t.startDate) = :month " +
    "AND YEAR(t.startDate) = :year")
})
public class Patient extends Person implements Serializable{
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "date_of_birth")
	private String dateOfBirth;
	private String address;

	public Patient() {
		super();
	}

	public Patient(String id, String name, String phone, Gender gender, String dateOfBirth, String address) {
		super(id, name, phone);
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}



}
