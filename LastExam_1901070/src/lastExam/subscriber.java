package lastExam;

public class subscriber implements Comparable<subscriber>{
	String id;
	String name;
	String pass;
	String type;
	public subscriber(String id,String name,String pass,String type) {
		this.id =id;
		this.name =name;
		this.pass=pass;
		this.type=type;
	}
	
	@Override
	public int compareTo(subscriber o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
