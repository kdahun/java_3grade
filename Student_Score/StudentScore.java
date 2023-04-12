package ksnu.a1901070.score;

import java.util.*;

public class StudentScore {
	
	public void printMenu() {
        System.out.println("<성적처리 프로그램>");
        System.out.println("1.학생 정보 입력하기");
        System.out.println("2.학생 정보보기");
        System.out.println("3.성적 입력하기(3과목)");
        System.out.println("4.성적 보기");
        System.out.println("5.성적 수정하기");
        System.out.println("6.평균 성적보기");
        System.out.println("0.메인메뉴 돌아가기");
    }
	public int er(Scanner scan) {
		int a=0;
		try {
			a = scan.nextInt();
		}catch(Exception e) {
			System.out.println("다시 입력해 주세요");
			scan.nextLine();
			a=er(scan);
		}
		
		return a;
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		Student st[]= new Student[10];
		Subject sub[]=new Subject[10];
		StudentScore ss=new StudentScore();
		
		int count_st=0;
		int count_sub=0;
		int sw_Num=0;
		String s;
		
		for(int i=0;i<10;i++) {
			st[i]=new Student();
			sub[i]=new Subject();
		}
		
		
		while(count_sub!=-1) {
			ss.printMenu();
			sw_Num=ss.er(scan);
			switch(sw_Num) {
			case 1:
				st[count_st].getName();
				System.out.print("이름 > ");
				s=scan.next();
				st[count_st].setName(s);
				
				st[count_st].getNum();
				System.out.print("학번 > ");
				s=scan.next();
				st[count_st].setNum(s);
				
				st[count_st].getPhone();
				System.out.print("전화 번호 > ");
				s=scan.next();
				st[count_st].setPhone(s);
				
				count_st++;
				break;
			
			case 2:
				System.out.println("학생 정보보기");
				for(int i=0;i<count_st;i++) {
					System.out.println("이름 : "+st[i].getName());
					System.out.println("학번 : "+st[i].getNum());
					System.out.println("전화 번호 : "+st[i].getPhone());
				}
				break;
			case 3:
				int score=0;
				System.out.println("성적 입력하기");
				System.out.print("성적 입력 : ");
				
				

				sub[count_sub].getKo();
				score=scan.nextInt();
				sub[count_sub].setKo(score);
				
				sub[count_sub].getEn();
				score=scan.nextInt();
				sub[count_sub].setEn(score);
				
				sub[count_sub].getMa();
				score=scan.nextInt();
				sub[count_sub].setMa(score);
				
				count_sub++;
			case 4:
				System.out.println("성적 보기");
				System.out.println("index 국어 영어 수학");
				for(int i=0;i<count_sub;i++) {
					System.out.println(st[i].getName()
							+" "+sub[i].getKo()
							+" "+sub[i].getEn()
							+" "+sub[i].getMa());
				}
			}
			
		}
		
		
	}
}
