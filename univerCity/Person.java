package univerCity;

public class Person {
	

	int num;
	String name;
	int birthYear;
	int admission;
	String belongs;
	
	Person(int num,String name, int birthYear, int admission,String belongs){
		this.num=num;
		this.name=name;
		this.birthYear=birthYear;
		this.admission=admission;
		this.belongs=belongs;
	}
	
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getAdmission() {
		return admission;
	}

	public String getBelongs() {
		return belongs;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public void setAdmission(int admission) {
		this.admission = admission;
	}

	public void setBelongs(String belongs) {
		this.belongs = belongs;
	}
}
