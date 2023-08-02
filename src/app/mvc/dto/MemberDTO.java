package app.mvc.dto;

public class MemberDTO {
	private int memberNo; //회원번호
	private String phone; //전화번호
	private int point; //보유 포인트
	private int grade; //회원 등급
	
	public MemberDTO() {}
	
	public MemberDTO(int memberNo, String phone, int point, int grade) {
		super();
		this.memberNo = memberNo;
		this.phone = phone;
		this.point = point;
		this.grade = grade;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [memberNo=");
		builder.append(memberNo);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", point=");
		builder.append(point);
		builder.append(", grade=");
		builder.append(grade);
		builder.append("]");
		return builder.toString();
	}
	
}
