package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity3.Member;
import entity3.Team;

public class Step03Test {

	static void logic(EntityManager em) {
		// 팀, 멤버 생성
		Team teamA = new Team();
		teamA.setName("teamA");
		em.persist(teamA);
		Member user1 = new Member();
		user1.setAge(20);
		user1.setName("user1");
		user1.setTeam(teamA);
		em.persist(user1);

		List<Member> members = new ArrayList<Member>();
		members.add(user1);
		teamA.setMembers(members);

		//
		Member member = em.find(Member.class, 2L);
		Team team = em.find(Team.class, 2L);
		member.setTeam(team);
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
