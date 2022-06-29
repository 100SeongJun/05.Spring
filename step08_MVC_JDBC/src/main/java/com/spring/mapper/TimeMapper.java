package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT NOW()")
	public String getTime();

	@Select("Select dname from dept where deptno=20")
	public String dept();

	public String getTime2();
}
