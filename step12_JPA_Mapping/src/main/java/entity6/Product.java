package entity6;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "Order")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	private String name;
	
//	@OneToMany(mappedBy="product")
	@OneToMany(mappedBy="product",cascade = CascadeType.REMOVE)
	private List<Order_data> Order = new ArrayList<Order_data>();
}
