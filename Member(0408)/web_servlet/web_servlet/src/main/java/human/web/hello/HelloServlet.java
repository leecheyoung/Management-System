package human.web.hello;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
//사용자의 요청URL에 대한 매핑: @WebServlet(URL) 사용
//Servlet 3.0부터 지원
//web.xml파일을 이용해서 사용자의 요청에 대한 서블릿 매핑
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3245316875235189158L;

	public HelloServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//서블릿이 처음 생성될 때 호출되는 메소드
		//생성시 1회 호출됨
		//서블릿이 기본생성자를 이용해서 생성되므로 필드의 초기화가 필요할 때 사용할 수 있음
		System.out.println("init()메소드 실행");
	}

	public void destroy() {
		//서블릿이 실행 종료될 때 호출되는 메소드
		System.out.println("destroy()메소드 실행");
	}

	//실제적으로 사용자의 요청에 대해 처리하는 메소드
	//사용자의 요청방식에 따라 정의해서 사용: 일반적으로 get/post 방식으로 호출
	//사용자의 요청방식에 따라 톰캣이 알아서 처리메소드를 호출함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메소드 실행");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메소드 실행");
	}

}
