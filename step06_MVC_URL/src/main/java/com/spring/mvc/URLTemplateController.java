package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 중괄호를 통해 값을 전달받을 수 있음
@Controller
public class URLTemplateController {
	@GetMapping("urlTest.do/{id}/home/{age}")
	public String urlTest1(@PathVariable String id, @PathVariable String age) {

		return "forward:/view.jsp";

	}

	@RequestMapping("urlTest2.do/{id}/home/{age}")
	public String urlTest2(Model model, @ModelAttribute("id") String id, @ModelAttribute("age") String age) {
		return "redirect:/view.jsp";
	}

}
