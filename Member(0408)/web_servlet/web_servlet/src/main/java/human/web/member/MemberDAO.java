package human.web.member;

import java.sql.SQLException;

public class MemberDAO extends DBConnection{

	public int join(MemberDTO dto) throws SQLException{
		
		int result = 0;//회원가입 실패 시 결과값
		
		//회원정보를 저장하기 위한 SQL구문을 정의함
		String sql="insert into tb_member (m_idx, member_id, member_pw, member_name, "
				+ "nickname, handphone, email) values(member_seq.nextval, ?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getMember_id());
		pstmt.setString(2, dto.getMember_pw());
		pstmt.setString(3, dto.getMember_name());
		pstmt.setString(4, dto.getNickname());
		pstmt.setString(5, dto.getHandphone());
		pstmt.setString(6, dto.getEmail());
		
		result = pstmt.executeUpdate();//데이터베이스에 적용된 row 수를 반환함
		
		return result;
	}

	public int login(String member_id, String member_pw) throws SQLException{
		//아이디와 비밀번호가 같은 데이터의 개수를 count()함수를 이용해서 가져옴
		//로그인 성공 시 1 반환, 실패 시 0 반환
		int result = 0; // 로그인 실패 시 결과값
		
		String sql = "select count(*) from tb_member where member_id = ? and member_pw = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member_id);
		pstmt.setString(2, member_pw);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			result = rs.getInt(1);
		}
		
		return result;
	}

	public MemberDTO getMember(String member_id) throws SQLException{
		MemberDTO dto = null;
		
		//아이디를 이용해서 회원정보를 가져오기
		String sql = "select * from tb_member where member_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member_id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setM_idx(rs.getInt("m_idx"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_name(rs.getString("member_name"));
			dto.setNickname(rs.getString("nickname"));
			dto.setHandphone(rs.getString("handphone"));
			dto.setEmail(rs.getString("email"));
			dto.setGrade(rs.getInt("grade"));
			dto.setReg_date(rs.getDate("reg_date"));
			dto.setUpdate_date(rs.getDate("update_date"));
			dto.setMember_status(rs.getInt("member_status"));
		}
		return dto;
	}

	public int update(MemberDTO dto) throws SQLException {
		int result = 0;//회원정보 변경 실패 시 결과값
		
		String sql="update tb_member set member_pw=?, member_name=?, nickname=?, "
						+ " handphone=?, email=? where m_idx=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getMember_pw());
		pstmt.setString(2, dto.getMember_name());
		pstmt.setString(3, dto.getNickname());
		pstmt.setString(4, dto.getHandphone());
		pstmt.setString(5, dto.getEmail());
		pstmt.setInt(6, dto.getM_idx());
		
		result = pstmt.executeUpdate();
		
		return result;
	}

	public MemberDTO getMember(int m_idx) throws SQLException{
		MemberDTO dto = null;
		
		//회원번호를 이용해서 회원정보를 가져오기
		String sql = "select * from tb_member where m_idx = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, m_idx);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setM_idx(rs.getInt("m_idx"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_name(rs.getString("member_name"));
			dto.setNickname(rs.getString("nickname"));
			dto.setHandphone(rs.getString("handphone"));
			dto.setEmail(rs.getString("email"));
			dto.setGrade(rs.getInt("grade"));
			dto.setReg_date(rs.getDate("reg_date"));
			dto.setUpdate_date(rs.getDate("update_date"));
			dto.setMember_status(rs.getInt("member_status"));
		}
		return dto;
	}

}















