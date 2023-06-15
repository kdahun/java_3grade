package 회원관리2;

import java.lang.Comparable; //패키지 import

public class person implements Comparable<person>{
	String id;
	String name;
	String pass;
	
	@Override
	public int compareTo(person anotherStudent) { //오버라이딩
		// TODO Auto-generated method stub
		return this.name.compareTo(anotherStudent.name);
	}
	
	public person(String id,String name,String pass) {
		this.id = id;
		this.name =name;
		this.pass= pass;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
