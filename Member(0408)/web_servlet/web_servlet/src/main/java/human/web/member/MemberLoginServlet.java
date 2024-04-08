package human.web.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/memberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSP페이지에서 전달된 아이디와 비밀번호 가져오기
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		
		//MemberDAO를 이용해서 로그인 처리하기
		MemberDAO dao = new MemberDAO();
		try {
			int result = dao.login(member_id, member_pw);
			
			//로그인이 정상적으로 이루어진 경우 session객체에 회원정보를 저장해서 메인페이지로 이동하고
			//로그인이 실패한 경우 "아이디나 비밀번호가 일치하지 않습니다"를 request객체에 저장해서 로그인페이지로 
			//이동하도록 함
			if(result == 1) {//로그인 성공 시
				MemberDTO dto = dao.getMember(member_id);
				//사용자를 구분하기 위한 객체로 톰캣에서 지원되는 객체: HttpSession객체 - 세션객체
				//request.getSession() 얻을 수 있음
				HttpSession session = request.getSession();
				//세션객체에 회원정보를 member라는 이름으로 저장함: setAttribute(String, Object)
				session.setAttribute("member", dto);
				//메인페이지를 새로 요청하기
				response.sendRedirect("../index.jsp");
				
			}else {//로그인 실패 시
				//request객체에 실패 메시지를 저장하기
				request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다");
				//request객체를 유지하면서 다른 페이지로 이동하기: forward()
				//RequestDispatcher객체의 forward()메소드 이용
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("로그인 처리 중 예외 발생");
			e.printStackTrace();
		}
	}

}
