package homework;

import java.util.Scanner;

class Day{
	private String work;
	public void set(String work) {
		this.work = work;
	}
	public String get() {
		return this.work;
	}
	public void show() {
		if(work ==null) {
			System.out.println("없습니다");
		}
		else System.out.println(this.work+"입니다");
	}
}

public class num7 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		Day day[]=new Day[30];
		for(int i=0;i<30;i++) {
			day[i]=new Day();
		}
		
		
		System.out.println("이번달 스케쥴 관리 프로그램.");
		
		int stop=0;
		while(stop!=3) {
			System.out.println("할일(입력:1, 보기:2, 끝내기:3) >>");
			stop=scan.nextInt();
			switch(stop) {
			case 1:
				System.out.print("날짜(1~30)? ");
				int date = scan.nextInt();
				System.out.print("할일(빈칸없이입력)? ");
				String work=scan.next();
				day[date].set(work);
				break;
			case 2:
				System.out.print("날짜(1~30)? ");
				int date2 = scan.nextInt();
				System.out.println(date2+"일의 할 일은 "+day[date2].get()+"입니다");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
