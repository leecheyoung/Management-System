<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "human.web.member.MemberDTO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보변경</title>
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
<h3>회원정보변경</h3>
<hr>

<%//세션에 저장되어 있는 회원정보를 가져오기 위해 스크립트릿 사용 
MemberDTO dto = (MemberDTO) session.getAttribute("member");
//각각의 input양식에 값을 출력하기 위해 표현식 사용
%>

<form method="post" action="memberUpdate" name="frm_join">
	<input type="hidden" name="m_idx" value="<%= dto.getM_idx() %>" >
	<input type="text" name="member_id" value="<%= dto.getMember_id() %>" disabled><br>
	<input type="password" name="member_pw" value="<%= dto.getMember_pw() %>" ><br>
	<input type="text" name="member_name" value="<%= dto.getMember_name() %>" ><br>
	<input type="text" name="nickname" value="<%= dto.getNickname() %>" ><br>
	<input type="text" name="handphone" value="<%= dto.getHandphone() %>" ><br>
	<input type="email" name="email" value="<%= dto.getEmail() %>" ><br>
	<input type="submit" value="변경하기">
	<input type="reset" value="취소하기">
</form>

<% //회원정보 변경 실패 시 메시지 출력
	String msg = null;
	msg = (String)request.getAttribute("msg");
	if(msg != null){
		out.println("<p>"+msg+"</p>");
	}
%>
	
</body>
</html>




