//package entity5;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//
//import lombok.Data;
//
//@Data
//@Entity
//public class Member {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "member_id")
//	private Long id;
//
//	@Column(length = 20)
//	private String name;
//	private Integer age;
//
//	@ManyToMany
////	@JoinColumn(name = "member_product")
//	@JoinTable(name = "member_product", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
//	private List<Product> products = new ArrayList<Product>();
//	
//	
//	// 
//	public void addProduct(Product product) {
//		products.add(product);
//		product.getMembers().add(this);
//	}
//}
