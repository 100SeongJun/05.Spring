package step04.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class People {

	private String name;
	private int age;
	// required(default: true) 참조하는 값이 없다면 error
	// false로 설정하면 참조하는 값이 없다면 다른 참조값을 찾아감
	@Autowired
//	@Autowired(required = false)
//	@Qualifier("c1")
	private Car myCar;

	public People() {
		System.out.println("People 기본 생성자");
	}

	public People(String name, int age, Car myCar) {
		this.name = name;
		this.age = age;
		this.myCar = myCar;
		System.out.println("사용자 정의 People 생성자");

	}
}
