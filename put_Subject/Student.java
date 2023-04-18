package ksnu.a1901070.score;

public class Student {
	String name;
	String num;
	String phone;
	
	public Student() {//생성자로 초기화
		this.name="이름 없음";
		this.num="학번 없음";
		this.phone="전화 번호 없음";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}