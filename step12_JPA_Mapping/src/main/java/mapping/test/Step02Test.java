package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity2.Member;
import entity2.Team;

public class Step02Test {

	static void logic(EntityManager em) {
//		Team team = new Team();
//		team.setName("TeamA");
//
//		em.persist(team);
//
//		Member member1 = new Member();
//		member1.setAge(20);
//		member1.setName("user1");
//		member1.setTeam(team);
//
//		em.persist(member1);
		Member member = em.find(Member.class, 1L);
		Team team = em.find(Team.class, 1L);
		System.out.println(member);
		System.out.println(team);
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
			System.out.println("???????????");
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
