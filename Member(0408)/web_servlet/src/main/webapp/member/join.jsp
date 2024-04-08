<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<style>
		input{
		width:200px;
		height:30px;
		line-height:30px;
		padding:5px;
		margin:5px;
		}
		input[type=submit],input[type=reset]{
		width:100px;
		height:50px;
		margin-top:20px;
		}
	
	</style>

</head>
<body>
<h3>회원가입</h3>
<hr>
	<form method="post" action="memberJoin" name="frm_join">
	<input type="text" name="member_id" placeholder="아이디"><br>
	<input type="password" name="member_pw" placeholder="비밀번호"><br>
	<input type="text" name="member_name" placeholder="이름"><br>
	<input type="text" name="nickname" placeholder="닉네임"><br>
	<input type="text" name="handphone" placeholder="핸드폰번호"><br>
	<input type="email" name="email" placeholder="이메일"><br>
	<input type="submit" value="가입하기">
	<input type="reset" value="취소하기">
	</form>
</body>
</html>