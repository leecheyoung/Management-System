package human.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/memberCancel")
public class MemberCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//회원탈퇴를 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//세션객체에 저장된 회원정보에서 회원번호 가져오기
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("member");
		//session.setAttribute(String name, Object value): 세션객체에 저장되는 값들이 저장되면서
		//모두 Object형으로 변환되어 저장됨: 업캐스팅(자동형변환)이 이루어짐
		//session.getAttribute(이름)으로 반환되는 값의 데이터형은 Object형(모든 클래스의 부모클래스)이므로
		//이것을 다운캐스팅(강제형변환)해주어야 자식클래스가 가지고 있는 내용을 사용할 수 있음
		int m_idx = dto.getM_idx();
		
		//DAO에서 회원번호로 해당 회원의 상태를 회원탈퇴 상태(-1)로 변경하기
		MemberDAO dao = new MemberDAO();
		
		int result = dao.cancel(m_idx);
		
		//회원탈퇴에 성공하면 세션객체를 초기화하고 메인페이지로 이동함
		//회원탈퇴에 실패하면 실패 메시지를 request객체에 저장해서 메인페이지로 이동함
		if(result == 1) {//회원탈퇴 성공 시
			//세션객체를 초기화함
			session.invalidate();
			//메인페이지로 이동
			response.sendRedirect("../index.jsp");
			
		}else {//회원탈퇴 실패 시
			//request객체에 실패 메시지 저장하기
			request.setAttribute("msg", "시스템의 문제로 회원탈퇴가 이루어지지 않았습니다. 빠른 시일 내에 시스템을 정상화하겠습니다");
			//request객체를 유지하면서 메인페이지로 이동하기: foward - RequestDispatcher
			RequestDispatcher dispatcher = request.getRequestDispatcher("../index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
