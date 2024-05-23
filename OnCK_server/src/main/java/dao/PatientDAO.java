package dao;

import java.util.List;
import java.util.Map;

import entities.Patient;

public interface PatientDAO {
	public boolean add(Patient patient);
	public List<Patient> findAll();
	public List<Patient> listPatients(String speciality, int month, int year);
	public Map<String, Long> getNoOfPatientsBySpeciality(String department);
	public boolean updateAddress(String patientID, String newAddress);
}
