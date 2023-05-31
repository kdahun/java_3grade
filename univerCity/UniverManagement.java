package univerCity;

import java.util.Scanner;

public class UniverManagement {
	public static void printMenu() {// 메뉴
		System.out.println("1. 대학 구성원 데이터 입력");
		System.out.println("2. 대학 구성원 데이터 전체 출력");
		System.out.println("3. 대학 구성원 데이터 조건 검색");
		System.out.println("4. 대학 구성원 데이터 변경");
		System.out.println("5. 대학 구성원 데이터 삭제");
		System.out.println("6. 끝내기");
	}

	static Scanner scan=new Scanner(System.in);
	static int intExcept() {//정수 예외 처리
		int a=0;
		try {
			a=scan.nextInt();
		}catch(Exception e) {
			System.out.println("정수를 입력해 주세요.");
			scan.nextLine();
			a=intExcept();
		}
		return a;
	}




	//static UniverManagement un=new UniverManagement();

	static Person[] persons=null;

	static void read() {
		System.out.println(">몇 명을 입력하시겠습니까?");
		int n= intExcept();
		persons = new Person[n];
		for(int i=0;i<n;i++) {

			System.out.println("> 1 : 구성원의 형태를 선택하세요");
			System.out.println("1. 일반인 2. 학생 3. 연구원 4. 교수");
			int selection=intExcept();

			while(selection>4||selection<1) {
				System.out.println("1~4 사이의 숫자를 입력해 주세요");
				selection=intExcept();
			}

			System.out.println("정보를 입력하세요.");
			int num=intExcept();
			String name=scan.next();
			int birthYear=intExcept();
			int admission=intExcept();
			String belongs=scan.next();
			switch(selection) {
			case 1:
				persons[i]=new Person(num,name,birthYear,admission,belongs);
				break;
			case 2:
				persons[i]=new Student(num, name, birthYear, admission, belongs);
				break;
			case 3:
				persons[i]=new Researcher(num, name, birthYear, admission, belongs);
				break;
			case 4:
				persons[i]= new Professor(num, name, birthYear, admission, belongs);
				break;

			}
		}
	}
	static void printAll() {
		try {
			for(Person p:persons) {

				if(p instanceof Professor)
					System.out.print("교수 : ");
				else if(p instanceof Student)
					System.out.print("학생 : ");
				else if(p instanceof Researcher)
					System.out.print("연구원: ");
				else if(p instanceof Person)
					System.out.print("일반인: ");
				System.out.println(p.getNum()+" "+ p.getName()+" "+ p.getBirthYear()+" "+ p.getAdmission()+" "+ p.getBelongs()+" ");

			}
		}catch(Exception e) {
			System.out.println("먼저 대학 구성원 데이터 입력하세요!");
		}
	}

	static void search() {
		System.out.println("> 다음 중에 선택하세요");
		System.out.println("1. 이름으로 검색 2. 나이로 검색");

		int searchHow = intExcept();
		while(searchHow>2||searchHow<1) {
			System.out.println("1 또는 2 입력");
			searchHow=intExcept();
		}

		switch(searchHow) {
		case 1:
			System.out.print("이름 입력 : ");
			String searchName=scan.next();
			System.out.println("검색 결과");
			for(Person p:persons) {
				if((p.getName()).equals(searchName)) {
					System.out.println(p.getNum()+" "+ p.getName()+" "+ p.getBirthYear()+" "+ p.getAdmission()+" "+ p.getBelongs()+" ");
					System.out.println();
					return;
				}
			}
			System.out.println("없음");
			break;
		case 2:
			System.out.print("\0 나이 범위 입력 : ");
			int a=0,b=0,stop2=0;

			while(stop2==0) {
				try {
					String searchAge=scan.next();
					String[] ageSplit=searchAge.split("-");
					a= Integer.parseInt(ageSplit[0]);
					b=Integer.parseInt(ageSplit[1]);
					stop2=1;
				}catch(Exception e) {
					System.out.println("나이 범위 올바르게!!");
					scan.nextLine();
				}
			}

			int count=1;
			for(Person p:persons) {
				int year=2024-p.getBirthYear();

				if(year<=b&&year>=a) {
					if(p instanceof Professor)
						System.out.print(count+": 교수 : ");
					else if(p instanceof Student)
						System.out.print(count+": 학생 : ");
					else if(p instanceof Researcher)
						System.out.print(count+": 연구원: ");
					else if(p instanceof Person)
						System.out.print(count+": 일반인: ");

					System.out.println(p.getNum()+" "+ p.getName()+" "+ p.getBirthYear()+" "+ p.getAdmission()+" "+ p.getBelongs()+" "+year);
					count++;
				}
			}
			System.out.println();
		}
		/*1 001211 홍길동 2002 190303 컴퓨터정보공학과
		2 981111 성춘향 2020 950121 연구소원
		3 151111 춘향 2015 140121 연구소삼
		4 181111 김춘향 1990 250121 연구소이
		2 911111 최춘향 1998 650121 연구소우
		 */
	}

	static void replace() {
		System.out.print("변경할 사람의 이름 : ");
		String replaceName=scan.next();
		boolean sw=true;
		for(Person p:persons) {
			if((p.getName()).equals(replaceName)) {
				System.out.println(p.getNum()+" "+ p.getName()+" "+ p.getBirthYear()+" "+ p.getAdmission()+" "+ p.getBelongs()+" ");
				System.out.println("바꿀 내용 입력");
				p.setNum(intExcept());
				p.setName(scan.next());
				p.setBirthYear(intExcept());
				p.setAdmission(intExcept());
				p.setBelongs(scan.next());
				sw=false;
				break;
			}
		}
		if(sw) {
			System.out.println("없음");
		}
	}

	static void trash() {
		System.out.print("삭제할 사람 이름 : ");
		String deleteName=scan.next();
		boolean sw2=true;
		Person persons2[]=new Person[persons.length];
		int cnt=0;
		for(Person p:persons) {
			if((p.getName()).equals(deleteName)) {
				System.out.println(p.getName()+" 삭제");
				sw2=false;
			}
			else {
				persons2[cnt]=p;
				cnt++;
			}
		}
		if(sw2) {
			System.out.println("없음");
			return;
		}
		persons=persons2;
	}
	
	public static void main(String args[]) {

		int stop=0;


		while(stop!=6) {
			printMenu(); // 메뉴 출력
			stop= intExcept(); // 예외처리
			switch(stop) {
			case 1:
				read();
				break;
			case 2:
				printAll();
				break;
			case 3:
				search();
				break;
			case 4:
				replace();
				break;
			case 5:
				trash();
				
				break;
			case 6:
				System.out.println("프로그램 종료");
				break;
			}


		}

	}
}
