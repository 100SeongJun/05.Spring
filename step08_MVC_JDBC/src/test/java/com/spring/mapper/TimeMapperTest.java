package com.spring.mapper;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class TimeMapperTest {
	@Inject
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {
		System.out.println("------" + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		System.out.println("------"+timeMapper.getTime2());
	}
}
