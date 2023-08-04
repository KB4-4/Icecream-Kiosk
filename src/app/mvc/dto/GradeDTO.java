package app.mvc.dto;

public class GradeDTO {
	private int gradeNo; // 등급번호
	private String gradeName; // 등급명
	private double rate; // 할인율
	private int standard; // 등급 요건

	public GradeDTO() {
	}

	public GradeDTO(int gradeNo, String gradeName, double rate, int standard) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
		this.rate = rate;
		this.standard = standard;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GradeDTO [gradeNo=");
		builder.append(gradeNo);
		builder.append(", gradeName=");
		builder.append(gradeName);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", standard=");
		builder.append(standard);
		builder.append("]");
		return builder.toString();
	}
}
