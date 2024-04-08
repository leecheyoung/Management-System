package human.web.member;

import java.util.Date;

public class MemberDTO {
	//JSP페이지의 input태그의 name과 DTO의 필드명과 DB의 컬럼명을 맞춤
	private String member_id;//아이디
	private String member_pw;//비밀번호
	private String member_name;//이름
	private String nickname;//닉네임
	private String handphone;//핸드폰번호
	private String email;//이메일
	
	//회원관리를 위해서 필요한 필드정의:회원번호,회원가입일,회원정보 수정일,회원등급(일반/관리자/슈퍼관리자),회원상태(유지/탈퇴)
	private int m_idx;//회원번호(오라클:member_seq.nextval, MySQL:자동증가함수)
	private Date reg_date;//회원가입일/등록일, join_date, 기본값:sysdate
	private Date update_date;//회원정보 수정일, modify_date, 기본값:sysdate
	private int grade;//회원등급(일반:0,관리자:1,슈퍼관리자:2), 기본값:0
	private int member_status;//회원상태(유지:1,탈퇴:-1), 기본값:1
	
	//getters and setters 메소드
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHandphone() {
		return handphone;
	}
	public void setHandphone(String handphone) {
		this.handphone = handphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}
	
	
	
	

}
