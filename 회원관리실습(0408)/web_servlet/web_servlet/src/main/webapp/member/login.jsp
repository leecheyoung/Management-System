<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<style>
		input{
		width:200px;
		height:30px;
		line-height:30px;
		padding:5px;
		margin:5px;
		}
		input[type=submit]{
		width:210px;
		height:50px;
		margin-top:20px;
		}
	
	</style>

</head>
<body>
<h3>로그인</h3>
<hr>
	<form method="post" action="memberLogin" name="frm_login">
		<input type="text" name="member_id" placeholder="아이디"><br>
		<input type="password" name="member_pw" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
	</form>
	
	<% //로그인 실패 시 메시지 출력
	String msg = null;
	msg = (String)request.getAttribute("msg");
	if(msg != null){
		out.println("<p>"+msg+"</p>");
	}
	
	%>
</body>
</html>