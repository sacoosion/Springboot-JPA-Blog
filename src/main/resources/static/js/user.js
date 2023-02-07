let index = {
	init : function(){
		$("#btn-save").on("click", ()=>{ // function(){}이 아닌 , ()=>를 사용하는것은 this를 바인딩하기 위해
			this.save();
		});
		$("#btn-update").on("click", ()=>{
			this.update();
		});
/*		//스프링 시큐리티 로그인 사용으로 더이상 사용 안함
		$("#btn-login").on("click", ()=>{ // function(){}이 아닌 , ()=>를 사용하는것은 this를 바인딩하기 위해
			this.login();
		});*/
	},
	
	save: function(){
		//alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		//console.log(data); //자바스크립트 오브젝트
		//console.log(JSON.stringify(data)); // JSON 문자열
		
		//ajax 호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 파라메터 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 나서 json을 리턴해주면 서버가 자동으로 자바 오브젝트로 변환해줌
		$.ajax({ 
			//회원가입 수행 요청 
			type: "POST",
			//url: "/api/user",
			//url: "/blog/api/user",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열 (생긴게 json이라면) => javascript 오브젝트로 변경
		}).done(function(resp){
			if(resp.status === 500){
				alert("회원가입이 실패하였습니다.");
			}else{
				alert("회원가입이 완료되었습니다.");
				location.href="/";
			}
			//console.log(resp);
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	
/*	//스프링 시큐리티 로그인 사용으로 더이상 사용 안함
	login: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};

		$.ajax({ 
			type: "POST",
			url: "/api/user/login",
			//url: "/blog/api/user/login",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열 (생긴게 json이라면) => javascript 오브젝트로 변경
		}).done(function(resp){
			alert("로그인이 완료되었습니다.");
			//console.log(resp);
			//location.href="/blog";
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}*/
	
	update: function(){
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		$.ajax({ 
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든것이 문자열 (생긴게 json이라면) => javascript 오브젝트로 변경
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			//console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
	
}

index.init();