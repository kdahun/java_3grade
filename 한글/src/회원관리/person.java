package 회원관리;

public class person {
	String id;
	String name;
	String pass;
	
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
