<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 예제: get방식 전송</title>
</head>
<body>
	<form method="get" action="memberInfo" name="frm">
	학년:<input type="text" name="year"><br>
	성별:<input type="radio" name="gender" value="남자" checked>남자
		<input type="radio" name="gender" value="여자" >여자<br>
	메일수신 여부:<input type="radio" name="receive_email" value="Y" checked>수신
		<input type="radio" name="receive_email" value="N">거부<br><br>
	관심분야를 선택하세요:<br>
	<input type="checkbox" name="item" value="정치/경제">정치/경제
	<input type="checkbox" name="item" value="사회">사회	
	<input type="checkbox" name="item" value="문화">문화<br>
	<input type="checkbox" name="item" value="IT/과학">IT/과학	
	<input type="checkbox" name="item" value="세계">세계	
	<input type="checkbox" name="item" value="생활">생활<br>	
		
	<input type="submit" value="get방식으로 전송">
	</form>
</body>
</html>