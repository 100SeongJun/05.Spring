package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA01Create {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud_JPA");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	private static JPA01Create jpa = new JPA01Create();

	private JPA01Create() {
	};

	public static JPA01Create getInstance() {
		return jpa;
	}

	public void runDB() {
		tx.begin();
	}

	public void commit() {
		tx.commit();
	}

	public void rollback() {
		tx.rollback();
	}

	public void close() {
		em.close();
		emf.close();
	}

}
