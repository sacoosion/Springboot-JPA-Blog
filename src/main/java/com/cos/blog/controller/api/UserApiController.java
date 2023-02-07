package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	//@PostMapping("/api/user")
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert하고 아래에서 return이 되면 됨.
		// user.setRole(RoleType.USER);  // 서비스로 이동
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으롸 변환해서 리턴(Jackson)
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ //@RequestBody가 걸려있지 않으면 json데이터를 받지 못함 키밸류타입밖에 못받음
																															   // key=value, x-www-form-urlencoded
		userService.회원수정(user);		
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됬음.
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 직접 세션값을 변경해줘야 한다.
		//세션등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		/* 
		 * Authentication authentication = new
		 * UsernamePasswordAuthenticationToken(principal, null,
		 * principal.getAuthorities()); SecurityContext securityContext =
		 * SecurityContextHolder.getContext();
		 * securityContext.setAuthentication(authentication);
		 * session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		 */
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	/*
	 * // 기본로그인 = > 스프링 시큐리티 이용해서 로그인
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody User user, HttpSession session) {
	 * System.out.println("UserApiController : login 호출됨"); User principal =
	 * userService.로그인(user); // principal (접근주체)
	 * 
	 * if (principal != null) { session.setAttribute("principal", principal); }
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */
}
