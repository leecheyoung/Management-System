package human.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DBConnection() {
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");//드라이버 로드
			String url = "jdbc:oracle:thin:@localhost:1521:xe";//DB Server에 대한 URL
			conn = DriverManager.getConnection(url, "web_dev", "1234");
			System.out.println("DB 연결 성공");
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
