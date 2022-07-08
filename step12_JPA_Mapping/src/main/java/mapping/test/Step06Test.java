package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity6.Member;
import entity6.Order_data;
import entity6.Product;
	
	public class Step06Test {
	
		static void logic(EntityManager em) {
			Member member1 = new Member();
			Product product = new Product();
			member1.setAge(20);
			member1.setName("user1");
			product.setName("상품E");
			em.persist(member1);
		em.persist(product);
		Order_data order = new Order_data();
		order.setMember(member1);
		order.setProduct(product);
		em.persist(order);
		
		Order_data data= em.find(Order_data.class, 1L);
		Member members = data.getMember();
//		em.remove(member1);
		Product products = data.getProduct();
		System.out.println(members);
		System.out.println(products);

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
