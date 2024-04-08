package human.web.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/*DBCP(DataBase Connection Pool)
- 톰캣에서 DB와의 작업을 효율적으로 하기 위해 연결 객체를 데이터베이스 풀로 관리하고 지원해주는 기법
- DBCP 매니저가 어느 정도의 연결객체를 확보해 놓고 있다가 사용자의 요청이 들어오면 연결객체를 지원해주고
  작업이 끝나면 연결객체를 DBCP 매니저에게 반환하도록 함
- 사용자의 요청을 처리하기 위해 매번 드라이버를 로드하고 연결객체를 생성해서 사용해야 하는 작업을 하지 않아도 됨
- DBCP를 사용하기 위해 Servers > server.xml 파일에서 <Context>요소에 다음의 내용을 추가함

  <Resource name="oracle_dbcp"
  			auth="Container"
  			type="javax.sql.DataSource"
  			driverClassName="oracle.jdbc.OracleDriver"
  			url="jdbc:oracle:thin:@localhost:1521:xe"
  			username="web_dev"
  			password="1234" />
  			
- 또는 여러 웹프로그램에서 DBCP를 적용할 경우 <GlobalNamingResources>요소에 위의 내용을 추가하고
  <Context>요소에는 다음의 내용을 추가함 
 
  <ResourceLink global="oracle_dbcp" 
                name="oracle_dbcp" 
                type="javax.sql.DataSource" />	

- 톰캣의 lib폴더에 ojdbc6.jar(오라클 드라이버 파일) 추가해줌 
 */

public class DBCP {
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DBCP() {
		try {
			//커넥션 풀(DataSource: 물리적인 커넥션 풀과의 연결을 생성해 주는 자바 표준 인터페이스) 얻기
			Context initCtx = new InitialContext();
			//JNDI를 이용하기 위해 InitialContext클래스로 Context객체를 생성함
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			//Context객체의 lookup("java:comp/env")를 이용해서 server.xml에 대한 Context객체 얻음
			DataSource source = (DataSource)ctx.lookup("oracle_dbcp");
			//Context객체의 lookup("oracle_dbcp")로 DBCP를 지원하는 DataSource객체 얻음
			
			//DataSource객체에서 연결객체 얻기
			conn = source.getConnection();
			
			System.out.println("DBCP 연결 성공");
			
		} catch (Exception e) {
			System.out.println("DBCP 연결 실패");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			
			System.out.println("DBCP 자원 반납");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
