<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "human.web.member.MemberDTO" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
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
<a href="#">로그아웃</a><br>
	
<% 	
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