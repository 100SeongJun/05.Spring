package entity6;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Order_data {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mpId;
	
	@ManyToOne
//	@JoinColumn(name = "member_id")
	@JoinColumn(name = "member_id",foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (member_id) references member (member_id) ON DELETE SET NULL"))
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
		
}
