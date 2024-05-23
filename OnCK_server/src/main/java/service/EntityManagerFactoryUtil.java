package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hospital");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getManager() {
		return entityManager;
	}
	
	public void closeEnManager() {
		entityManager.close();
	}
	
	public void closeEnMaFactory() {
		entityManagerFactory.close();
	}

}
