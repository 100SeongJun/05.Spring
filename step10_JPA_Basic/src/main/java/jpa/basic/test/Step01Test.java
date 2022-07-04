package jpa.basic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// insert
		Member insertMember = new Member();
		insertMember.setId("id3");
		insertMember.setUserName("jpa1");
		insertMember.setAge(27);
//		em.persist(insertMember);

		// select
		Member member1 = em.find(Member.class, "id1");

//		System.out.println("----------");
//		System.out.println(member01);
//		System.out.println("----------");

		// JPQL
		// 대문자로 사용해야함 / 별칭을 사용해야함 (* 사용못함)
//		List<Member> allMembers = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println("----------");
//		for (Member m : allMembers) {
//			System.out.println(m);
//			System.out.println("----------");
//		}
		/*-
		 * 반환타입이 명확할 경우 TypedQuery, 불명확할 경우 Query라는 Return Type 사용 
		 * TypedQuery<Member> typedQuery = em.createQuery("select m from Member m",Member.class); 
		 * List<Member> allMember = typedQuery.getResultList();
		 * 결과로 반환받는 데이터 객체가 정확히 하나일 경우 사용 - 없거나 많으면 Exception 발생 
		 * em.createQuery("select m from Member m").getSingleResult();
		 */

		// update
		// 모든 멤버변수(필드) set, 업데이트 대상에서 지정되지 않은 멤버변수 데이터는 기존 유지
		// em.find를 통해 db에 접근해야함.
		/*- 동작원리
		 *  
		 *  flush() : 내부 쿼리 저장소에 있는 SQL이 DB에 동기화되는 것
		 *  1. flush() <= tx.commit() 자동 호출
		 *  2. 엔티티 스냅샷과 변경된 엔티티를 비교
		 *  3. 변경된 엔티티가 존재하면 update 쿼리를 생성
		 *  4. 쓰기지연 SQL 저장소 저장
		 *  5. dB 전송 -> DB tx.commit();
		 *  */

		// 영속성 컨텍스트를 초기화하는 clear가 작동 시
//		em.clear();
		em.detach(member1);
		em.merge(member1);
		member1.setAge(37);
//		em.persist(insertMember);

		// delete
		// 우선 find를 통해 객체를 select 하고 remove를 해야함
//		em.remove(member1);
//		tx.commit();

	}

}
