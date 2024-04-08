<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 예제: post방식 전송</title>
</head>
<body>
	<form method="post" action="memberInfo" name="frm">
	아이디:<input type="text" name="member_id"><br>
	비밀번호:<input type="password" name="member_pw"><br>
	이름:<input type="text" name="member_name"><br>
	닉네임:<input type="text" name="nickname"><br>
	핸드폰번호:<input type="text" name="handphone"><br>
	이메일:<input type="email" name="email"><br>
		
	<input type="submit" value="post방식으로 전송">
	</form>
</body>
</html>