package homework;

import java.util.Scanner;

class Phone{
	String name;
	String phone;
	
	public Phone(String name,String phone) {
		this.name=name;
		this.phone=phone;
	}
	
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone;
	}
}

public class num8 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("인원수 >> ");
		int peple = scan.nextInt();
		
		Phone np[]=new Phone[peple];
		
		for(int i=0;i<peple;i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력) >>> ");
			String name=scan.next();
			String phone=scan.next();
			np[i]=new Phone(name,phone);
		}
		System.out.println("저장되었습니다.");
		
		String stop=" ";
		
		while(!stop.equals("그만")) {
			System.out.print("검색할 이름 >>");
			stop=scan.next();
			for(int i=0;i<peple;i++) {
				if(stop.equals(np[i].getName())) {
					System.out.println(stop+"의 번호는 "+np[i].getPhone()+"입니다.");
					break;
				}
				if(i==peple-1&&!stop.equals("그만")) {
					System.out.println(stop+"는 없습니다.");
				}
			}
		}
	}
}
