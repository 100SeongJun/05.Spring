package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private Long id;
	@Column(length = 20)
	private String name;
	@Column(length = 3)
	private Integer age;

}
