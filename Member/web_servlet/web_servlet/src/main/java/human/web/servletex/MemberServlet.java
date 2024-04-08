package human.web.servletex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form/memberInfo")
public class MemberServlet extends HttpServlet {

	//톰캣에서 서블릿을 구분하는 고유한 값
	private static final long serialVersionUID = 7682222083537636661L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//먼저 get방식으로 넘어오는 한글 데이터의 깨짐 방지를 위해서 Servers > server.xml파일에서 <Connector>요소에
		//URIEncoding="UTF-8"을 추가해줌
		
		//request객체에 저장된 값들 가져오기: getParameter(쿼리스트링의 name)
		String year = request.getParameter("year");
		String gender = request.getParameter("gender");
		String receiveEmail = request.getParameter("receive_email");
		//같은 이름으로 여러 개의 값이 서버로 전달된 경우:getParameterValues(쿼리스트링의 name):String[]
		String[] items = request.getParameterValues("item");
		
		//응답내용에 대해 타입과 문자셋을 지정함
		response.setContentType("text/html; charset=UTF-8");
		
		//응답객체에 내용을 출력할 수 있는 출력객체 가져오기:PrintWriter ~ response의 getWriter()
		PrintWriter out = response.getWriter();
		
		//응답내용으로 보낼 HTML문서 만들기
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>get방식으로 전송된 값들</title></head>");
		out.println("<body>");
		out.println("<h3>get방식전송에 대한 응답</h3><hr>");
		out.println("학년 : "+year);
		out.println("<br>성별 : "+gender);
		out.println("<br>메일수신 여부 : "+receiveEmail);
		out.println("<br>관심분야 : ");
		//배열에 저장된 데이터를 하나씩 가져와서 사용할 때 유용하게 사용할 수 있는 for문: 확장for문(foreach문)
		//(형식) for(데이터형 변수 : 배열 또는 컬렉션)
		for(String item : items) {
			out.println(item + " ");
		}
		out.println("</body></html>");
		
		out.close();
		
		
	}

	//post방식으로 전달되는 요청에 대해 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 전달되는 데이터 중 한글 깨짐 방지를 위한 조치
		//request.setCharacterEncoding("UTF-8");
		//매번 위 코드를 추가하지 않고 web.xml파일에 한글 필터를 추가해서 처리함
		/*
		 <!-- 한글 깨짐 방지를 위한 필터 설정 -->
		  <filter>
		  	<filter-name>HangulEncoding</filter-name>
		  	<filter-class>org.apache.catalina.filters.SetCharacterEncodingFilter</filter-class>
		  	<init-param>
		  		<param-name>encoding</param-name>
		  		<param-value>UTF-8</param-value>
		  	</init-param>
		  </filter>
		  
		  <filter-mapping>
		  	<filter-name>HangulEncoding</filter-name>
		  	<url-pattern>/*</url-pattern>
		  </filter-mapping>
		 */
		
		//form02.jsp페이지에서 아이디, 비밀번호, 이름, 닉네임, 핸드폰번호, 이메일을 전달할 수 있도록 정의하고
		//MemberServlet에서는 전달받은 값을 그대로 출력되도록 응답 처리하는 구문을 작성하시오.
		
		
		//request객체에 저장된 값들 가져오기: getParameter(쿼리스트링의 name)
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String nickname = request.getParameter("nickname");
		String handphone = request.getParameter("handphone");
		String email = request.getParameter("email");
		
		//응답내용에 대해 타입과 문자셋을 지정함
		response.setContentType("text/html; charset=UTF-8");
		
		//응답객체에 내용을 출력할 수 있는 출력객체 가져오기:PrintWriter ~ response의 getWriter()
		PrintWriter out = response.getWriter();
		
		//응답내용으로 보낼 HTML문서 만들기
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>post방식으로 전송된 값들</title></head>");
		out.println("<body>");
		out.println("<h3>post방식전송에 대한 응답</h3><hr>");
		out.println("아이디 : "+member_id);
		out.println("<br>비밀번호 : "+member_pw);
		out.println("<br>이름 : "+member_name);
		out.println("<br>닉네임 : "+nickname);
		out.println("<br>핸드폰번호 : "+handphone);
		out.println("<br>이메일 : "+email);
		
		out.println("</body></html>");
		
		out.close();
		
		
	}
	
	
	

}
