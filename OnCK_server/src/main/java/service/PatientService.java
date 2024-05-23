package service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.PatientDAO;
import entities.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PatientService implements PatientDAO{
	private EntityManager entityManager;

	public PatientService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public boolean add(Patient patient) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(patient);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Patient> findAll() {
		return entityManager.createNamedQuery("Patient.findAll", Patient.class).getResultList();
	}

	@Override
	public List<Patient> listPatients(String speciality, int month, int year) {
		return entityManager.createNamedQuery("Patient.listPatients", Patient.class)
				.setParameter("speciality", speciality).setParameter("month", month).setParameter("year", year)
				.getResultList();
	}

	@Override
	public Map<String, Long> getNoOfPatientsBySpeciality(String department) {
		Map<String, Long> map = new LinkedHashMap<>();

		String queryString = "SELECT d.speciality, COUNT(p) FROM Doctor d " 
		+ "INNER JOIN d.department dept "
		+ "INNER JOIN Treatment t ON d.id = t.doctor.id " 
		+ "INNER JOIN Patient p ON t.patient.id = p.id "
		+ "WHERE dept.name = :departmentName " 
		+ "GROUP BY d.speciality";

		List<Object[]> list = entityManager.createQuery(queryString).setParameter("departmentName", department).getResultList();

		for (Object[] row : list) {
			String speciality = (String) row[0];
			Long count = (Long) row[1];
			map.put(speciality, count);
		}

		return map;
	}

	@Override
	public boolean updateAddress(String patientID, String newAddress) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Patient patient = entityManager.find(Patient.class, patientID);
			if (patient != null) {
				patient.setAddress(newAddress);
				trans.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
}
