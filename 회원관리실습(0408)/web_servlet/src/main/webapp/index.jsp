<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "human.web.member.MemberDTO" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>

<script>

function cancel(){//회원탈퇴에 대한 처리 함수
	//confirm창에 확인를 클릭하면 true, 취소를 클릭하면 false 반환
	const answer = confirm("정말 회원탈퇴 하겠습니까?");
	//개발자 모드에서 콘솔에서 answer 확인:console.log()
	console.log("answer: "+answer);
	
	if(answer){
		//서버로 회원탈퇴 요청을 보냄(get방식)
		location.href = "member/memberCancel";
	}
}

</script>


</head>
<body>

<h3>메인페이지</h3>
<hr>

<% 
//JSP페이지에서 자바 소스를 사용해서 작업할 때 사용되는 스크립트 요소 중 하나: 스크립트릿

//JSP에서는 session객체를 별도로 가져올 필요없이 내장객체로 지원되는 session객체를 이용할 수 있음
//Java 클래스는 page지시자의 import속성을 이용해서 처리함
MemberDTO dto = (MemberDTO) session.getAttribute("member");

//회원인 경우 dto가 null이 아님
if(dto != null){//회원인 경우
%>	

<!-- 회원에게 보여지는 화면  -->
<%= dto.getNickname() %>님<br> <!-- JSP페이지에서 자바소스 코드의 값을 출력하는데 사용되는 스크립트 요소: 표현식 -->
<a href="member/update.jsp">회원정보변경</a><br>
<!-- 로그아웃은 별도의 화면을 필요로 하지 않기 때문에 바로 서버에 URL로 로그아웃 요청함(get방식) -->
<a href="member/memberLogout">로그아웃</a><br>
<!-- 회원탈퇴는 회원으로 하여금 다시 한번 확인하는 절차를 거치므로 자바스크립트로 confirm창을 띄워서 확인 후 
     회원탈퇴 요청을 처리함 -->
<a href="javascript:cancel();">회원탈퇴</a><br>

	
<% 	

//회원정보 탈퇴 실패 시 메시지 출력
String msg = null;
msg = (String)request.getAttribute("msg");
if(msg != null){
	out.println("<p>"+msg+"</p>");
}

}else{//비회원인 경우
%>

<!-- 비회원에게 보여지는 화면  -->
<a href="member/join.jsp">회원가입</a><br>
<a href="member/login.jsp">로그인</a><br>
	
<%		
}
%>



</body>
</html>