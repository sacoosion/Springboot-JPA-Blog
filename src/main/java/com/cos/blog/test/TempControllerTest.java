package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//http://localhost:8090/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resources/static
		//리턴명 : /home.html
		//풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpeg";
	}
	
	@GetMapping("/temp/jsp")
	public String testJsp() {
		//prefix: /WEB-INF/views/
		//suffix: .jsp
		//풀네임 : /WEB-INF/views/test.jsp
		return "test";
	}
	
}
