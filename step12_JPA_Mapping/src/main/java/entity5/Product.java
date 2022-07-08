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
//import javax.persistence.ManyToMany;
//
//import lombok.Data;
//import lombok.ToString;
//
//@Data
//@Entity
//@ToString(exclude = {"members"})
//public class Product {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "product_id")
//	private Long id;
//
//	private String name;
//	
//	@ManyToMany(mappedBy = "products")
//	private List<Member> members = new ArrayList<Member>();
//}
