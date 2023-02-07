<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<!-- <form action="/blog/api/user/login"> -->
	<form	 action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password"  name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<!-- <div class="form-group form-check">
			<label class="form-check-label"> 
			<input name="remember" class="form-check-input" type="checkbox"> Remember me
			</label>
		</div> -->
				<button id="btn-login" class="btn btn-primary">로그인</button>
				<a href="https://kauth.kakao.com/oauth/authorize?client_id=73d5ecb33a170699c7c538705a190d9a&redirect_uri=http://localhost:8090/auth/kakao/callback&response_type=code" ><img src="/image/kakao_login_button.png" height="38px"></a>
	</form>
</div>

<!-- 시큐리티 로그인으로 사용안함<script src="/blog/js/user.js"></script>  -->
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>