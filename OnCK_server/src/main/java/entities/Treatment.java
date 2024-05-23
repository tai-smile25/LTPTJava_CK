package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "treatments")
public class Treatment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private String diagnosis;

	@Id
    @Column(name = "doctor_id")
    private String doctorId;

    @Id
    @Column(name = "patient_id")
    private String patientId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "person_id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "person_id")
	private Patient patient;

	public Treatment() {
		super();
	}

	public Treatment(LocalDate startDate, LocalDate endDate, String diagnosis, String doctorId, String patientId,
			Doctor doctor, Patient patient) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.diagnosis = diagnosis;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.doctor = doctor;
		this.patient = patient;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Treatment [startDate=" + startDate + ", endDate=" + endDate + ", diagnosis=" + diagnosis + ", doctorId="
				+ doctorId + ", patientId=" + patientId + ", doctor=" + doctor + ", patient=" + patient + "]";
	}

	
}
