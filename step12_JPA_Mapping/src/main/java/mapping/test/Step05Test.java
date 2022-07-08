//package mapping.test;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import entity5.Member;
//import entity5.Product;
//
//public class Step05Test {
//
//	static void logic(EntityManager em) {
//		Product productA = new Product();
////		productA.setId(1L);
//		productA.setName("상품D");
//		Member member1 = new Member();
////		member1.setId(1L);
//		member1.setAge(27);
//		member1.setName("멤버1");
//		
//		//양방향 참조 시 추가
////		member1.getProducts().add(productA);
////		productA.getMembers().add(member1);
//		member1.addProduct(productA);
////		em.persist(productA);
////		em.persist(member1);
//		
//		//find		
//		Member member01 = em.find(Member.class, 1L);
//		Product product01 = em.find(Product.class, 1L);
//		List<Member> members = product01.getMembers();
//		System.out.println(member01);
//		for(Member member : members) {
//			System.out.println(member);
//		}
////		System.out.println(member01);
////		System.out.println(product01);
////		List<Product> products = member01.getProducts();
////		for(Product product: products) {
////			System.out.println(product);
////		}
//	}
//
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		try {
//			logic(em);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			em.close();
//			emf.close();
//		}
//	}
//}
