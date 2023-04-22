package ksnu.a0000001.class3;

public class Subject {

	// 과목 이름
	private String name;
	// 과목 점수
	private int score;
	
	// 과목 클래스 생성자
	public Subject(String name, int score) {
		this.name = name;
		this.score = score;
	}

	// getter/setter 메소드 모음
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
