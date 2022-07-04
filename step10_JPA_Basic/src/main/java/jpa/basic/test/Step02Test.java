package jpa.basic.test;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.basic.enumtype.MemberType;
import step02.entity.Member2;

public class Step02Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Scanner sc = new Scanner(System.in);

//		System.out.println("나이를 입력하세요:");
//		Integer age = sc.nextInt();
//		System.out.println("이름을 입력하세요:");
//		String name = sc.next();
		tx.begin();
		try {
			insert(em, 15, "Test", MemberType.NORMAL);
			select(em, 2L);
			tx.commit();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

	private static void insert(EntityManager em, Integer age, String name, MemberType memberType) {

		Member2 member2 = new Member2();
//		insert
		member2.setAge(age);
		member2.setName(name);
		member2.setMemberType(memberType);
		member2.setRegistrationTime(LocalDateTime.now());
		em.persist(member2);
	}

	private static void select(EntityManager em, Long id) {
		Member2 member2 = new Member2();
		member2 = em.find(Member2.class, id);
		System.out.println(member2);
	}
}
