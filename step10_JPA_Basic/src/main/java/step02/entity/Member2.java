package step02.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jpa.basic.enumtype.MemberType;
import lombok.Data;

@Data
@Entity
public class Member2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
	private Long id;
	private String name;
	private Integer age;
	// log
	@Column(name = "reg_time")
	private LocalDateTime registrationTime;

	@Column(name = "member_type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date loginTime2;

}
