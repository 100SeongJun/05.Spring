package entity4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;
	private Integer age;

	//
	@ManyToOne(fetch = FetchType.LAZY)
	/*- 개별 select 실행
	 *  실제로 데이터를 필요로하는 시점에만 select 실행
	 *  - 주의사항  : toString을 사용하는경우 팀값만 반환하는 로직이 포함되어 이다면,
	 *  팀과 관련된 select String을 재정의 해야한다. 
	*/
	@JoinColumn(name = "team_id")
	private Team team;
}
