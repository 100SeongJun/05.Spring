package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;
import entity.Team;

public class Step01Test {

	static void logic(EntityManager em) {
//		Team team = new Team();
//		team.setName("TeamA");
//
//		em.persist(team);
//
//		Member member1 = new Member();
//		member1.setAge(20);
//		member1.setName("user1");
//		member1.setTeamId(team.getId());
//
//		em.persist(member1);
		Member member11 = em.find(Member.class, 1L);
		Team team11 = em.find(Team.class, 1L);
		System.out.println(member11);
		System.out.println(team11);
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
