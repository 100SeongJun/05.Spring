package com.spring.aop;

public class Car {
	// 구매
	public void buy() {
		System.out.println("자동차 구매");
	}

	public void buyMoney(int money) {
		System.out.println("자동차 구매금액:" + money);
	}

	public String buyReturn() {
		return "구매완료";
	}

	public void sellCar(int money) throws Exception {
		if (money <= 1000) {
			throw new Exception("너무 저렴함");
		}
	}
}
