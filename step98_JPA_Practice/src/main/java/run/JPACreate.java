package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPACreate {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("scott_User");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction tx = em.getTransaction();
	private static JPACreate instance = new JPACreate();

	private JPACreate() {
	}

	public static JPACreate getInstance() {
		return instance;
	}

	public EntityManagerFactory emf() {
		return emf;
	}

	public EntityManager em() {
		return em;
	}

	public EntityTransaction tx() {
		return tx;
	}
}
