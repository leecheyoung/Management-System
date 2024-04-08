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

@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//6개의 회원정보를 저장할 수 있는 객체 필요: DTO(Data Transfer Object) - MemberDTO
		MemberDTO dto = new MemberDTO();
		dto.setM_idx(Integer.parseInt(request.getParameter("m_idx")));
		dto.setMember_pw(request.getParameter("member_pw"));
		dto.setMember_name(request.getParameter("member_name"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setHandphone(request.getParameter("handphone"));
		dto.setEmail(request.getParameter("email"));
		
		//MemberDAO를 이용해서 회원정보 변경 처리하기
		MemberDAO dao = new MemberDAO();
		
		int result = dao.update(dto);
		
		//회원정보 변경이 정상적으로 이루어진 경우 session객체에 새로운 회원정보를 저장해서 메인페이지로 이동하고
		//회원정보 변경이 실패한 경우 "시스템의 문제로 회원정보 변경이 이루어지지 않았습니다. 빠른 시일 내에 시스템을 정상화하겠습니다"를 
		//request객체에 저장해서 회원정보 변경페이지로 이동하도록 함
		if(result == 1) {//회원정보 변경 성공 시
			MemberDTO newDto = dao.getMember(Integer.parseInt(request.getParameter("m_idx")));
			//사용자를 구분하기 위한 객체로 톰캣에서 지원되는 객체: HttpSession객체 - 세션객체
			//request.getSession() 얻을 수 있음
			HttpSession session = request.getSession();
			//세션객체에 회원정보를 member라는 이름으로 저장함: setAttribute(String, Object)
			session.removeAttribute("member");//기존에 저장된 dto객체를 삭제함
			session.setAttribute("member", newDto);
			//메인페이지를 새로 요청하기
			response.sendRedirect("../index.jsp");
			
		}else {//회원정보 변경 실패 시
			//request객체에 실패 메시지를 저장하기
			request.setAttribute("msg", "시스템의 문제로 회원정보 변경이 이루어지지 않았습니다. 빠른 시일 내에 시스템을 정상화하겠습니다");
			//request객체를 유지하면서 다른 페이지로 이동하기: forward()
			//RequestDispatcher객체의 forward()메소드 이용
			RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);
			
		}
			
	}

}
