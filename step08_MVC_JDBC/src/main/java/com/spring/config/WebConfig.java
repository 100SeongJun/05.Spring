//package com.spring.config;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] {RootConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] {ServletConfig.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] {"/"};
//	}
//	
//	//CORS
//	public void addCorsMapping(CorsRegistry registry) {
////		registry.addMapping("/api");
//		registry.addMapping("/**")
//			.allowedOrigins("http://localhost:3000")
//			.allowedMethods("GET")
//			.allowedMethods("POST");
//	}
//	
//}
