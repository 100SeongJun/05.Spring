package com.spring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class NoticeAspect {
	//���� �� ���� ����
	@Before("execution(* com.spring.aop.Car.buy*(..))")
	public void noticeBuyStart() {
		System.out.println("�����Ͻ� �ǰ���?");
	}
	//���� �� ��� ����
	@After("execution(* com.spring.aop.Car.buy*(..))")
	public void noticeBuyEnd() {
		System.out.println("���Ÿ� �Ϸ��ϼ̽��ϴ�.");
	}
	
	//���ϰ��� �ִ� �޼ҵ忡�� �����ϴ� ���� ����
	@AfterReturning(pointcut = "execution(* com.spring.aop.Car.buy*(..))", returning="v")
	public void noticeReturnValue(String v) {
		if(v != null) {
			System.out.println("���� �� ó�� ���� :" + v);
		}
	}
	//����ó���� �ϴ� ���� ����
	@AfterThrowing(pointcut = "execution(* com.spring.aop.Car.buy*(..))", throwing="exception")
	public void noticeSellException(Exception exception) {
		System.out.println("�߻��� ���� :" + exception.getMessage());
	}
}
