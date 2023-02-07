package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@RequiredArgsConstructor //보통 데이터베이스에서 값을 가져오기때문에 불멸성을 위하여 final을 붙일때 사용
@Data
//@AllArgsConstructor	//전체생성자
@NoArgsConstructor //빈생성자
public class Member {
	private int id; 
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
