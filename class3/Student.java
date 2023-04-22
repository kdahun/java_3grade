package ksnu.a0000001.class3;

public class Student {
	
	// 학생 이름
	private String name;
	// 학생 학번
	private String stdNo;
	// 학생 전화번호
	private String phone;
	
	// 과목 클래스 배열
	private Subject[] sbjArr;
	
	// 학생 클래스 생성자
	public Student(String name, String stdNo, String phone) {
		this.name = name;
		this.stdNo = stdNo;
		this.phone = phone;
	}

	// 과목 객체 생성
	public void createSbjArr(int sbjCnt) {
		this.sbjArr = new Subject[sbjCnt];
	}

	// getter/setter 메소드 모음
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Subject[] getSbjArr() {
		return sbjArr;
	}
	public void setSbjArr(Subject[] sbjArr) {
		this.sbjArr = sbjArr;
	}
}
