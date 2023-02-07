package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

// DAO
// 자동으로 bean 등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);

	//시큐리티 로그인을 사용하므로 사용 안함
	//JPA Namin 쿼리 전략
	// select * from user where username = ?1 and password = ?2;
	//User findByUsernameAndPassword(String username, String password);
	/*
	 * @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2",
	 * nativeQuery = true) User login(String username, String password);
	 */
}
