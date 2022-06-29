package com.spring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {
	@Around("within(com.spring.aop.*)")
	public Object aroundAspect(ProceedingJoinPoint point) {
		System.out.println("전처리");
		System.out.println("구매 하시겠습니까?");

		Object returnValue = null;

		try {
			returnValue = point.proceed();
			System.out.println("리턴 후 로직 " + returnValue);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("발생한 문제 : " + e.getMessage());
		}
		System.out.println("후처리");
		System.out.println("구매를 완료하습니다.");

		return returnValue;
	}
}
