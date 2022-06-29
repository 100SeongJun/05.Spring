package com.spring.common;

public class NoticeAspect {
	// 구매 전 공통로직
	public void noticeBuyStart() {
		System.out.println("구매하실 건가요?");
	}

	// 구매 후 공통 로직
	public void noticeBuyEnd() {
		System.out.println("구매가 완료되었습니다.");
	}

	// 리턴값이 있는 메소드에만 적용하는 공통 로직
	public void noticeReturnValue(String v) {
		if (v != null) {
			System.out.println("리턴 후 처리 로직: " + v);
		}
	}

	// 예외 처리를 하는 공통로직
	public void noticeSellException(Exception e) {
		System.out.println("발생된 예외 : " + e.getMessage());
	}
}
