package ksnu.a1901070.score;

import java.util.*;

public class StudentScore {

	public void printMenu() {
        System.out.println("<성적처리 프로그램>");
        System.out.println("1.학생 정보 입력하기");
        System.out.println("2.학생 정보보기");
        System.out.println("3.과목 입력하기");
        System.out.println("4.성적 입력하기");
        System.out.println("5.성적 보기");
        System.out.println("6.성적 수정하기");
        System.out.println("7.평균 성적보기");
        System.out.println("0.메인메뉴 돌아가기");
    }

	public int er(Scanner scan) {
		int a=0;
		try {
			a = scan.nextInt();
		}catch(Exception e) {
			System.out.println("다시 입력해 주세요");
			printMenu();
			scan.nextLine();
			a=er(scan);
		}

		return a;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int num=0;


		int subject_num=0;


		StudentScore ss=new StudentScore();

		int count_st=0;
		int count_sub=0;
		int sw_Num=0;
		String s;
		String subject_name[]=new String [100];
		int subject_score[]=new int [300];


		Student st[]= new Student[100];
		Subject sub[]=new Subject[100];
		for(int i=0;i<100;i++) {
			st[i]=new Student();
			sub[i]=new Subject();
		}


		while(count_sub!=-1) {
			ss.printMenu();
			sw_Num=ss.er(scan);
			switch(sw_Num) {
			case 1:
				st[count_st].getName();
				System.out.print("몇 명의 학생 정보를 입력하시겠습니까?>");
				num=scan.nextInt();
				for(int i=0;i<num;i++) {

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
				}
				break;

			case 2:
				int selet=0;
				String name_s;
				System.out.println("학생 정보보기");
				System.out.print("학생 선택(이름) > ");
				name_s=scan.next();
				for(int i=0;i<count_st;i++) {
					if(name_s.equals(st[i].name)) {
						selet=i;
					}
				}


				System.out.println("이름 : "+st[selet].getName());
				System.out.println("학번 : "+st[selet].getNum());
				System.out.println("전화 번호 : "+st[selet].getPhone());

				break;
			case 3:
				int score=0;
				System.out.println("과목 입력하기");
				System.out.print("과목 개수 > ");

				subject_num=scan.nextInt();
				System.out.print("과목 이름 > ");
				for(int i=0;i<subject_num;i++) {
					subject_name[i]=scan.next();
				}



				//sub[count_sub].getKo(100);
				//score=scan.nextInt();
				//sub[count_sub].setKo(score);


				count_sub++;
				break;
			case 4:
				System.out.println("성적 입력하기");
				System.out.print("학생 선택(이름)");
				String name1=scan.next();
				for(int i=0;i<count_st;i++) {
					if(st[i].name.equals(name1)) {
						System.out.print("성적 입력 : ");
						for(int j=0;j<subject_num;j++) {
							subject_score[i*subject_num+j]=scan.nextInt();
						}
					}
				}
				break;
			case 5:
				System.out.println("성적보기");
				for(int i=0;i<num;i++) {
					System.out.print(st[i].name);
					for(int j=0;j<subject_num;j++) {
						System.out.print("    "+subject_score[i*subject_num+j]);
					}
					System.out.println();
				}
				
				break;
			case 6:
				String k;
				System.out.println("성적 수정하기");
				System.out.println("학생 선택(이름) >");
				k=scan.next();
				for(int i=0;i<num;i++) {
					if(k.equals(st[i].name)) {
						System.out.print("현재 :");
						for(int j=0;j<subject_num;j++) {
							System.out.print(subject_score[i*subject_num+j]+" ");
						}
						System.out.println();
						System.out.print("새로운 성적 :");
						for(int j=0;j<subject_num;j++) {
							subject_score[i*subject_num+j]=scan.nextInt();
						}
						System.out.println();
					}
				}
				break;
			case 7:
				String k1;
				System.out.println("평균 성적보기");
				System.out.println("학생 선택(이름) >");
				k1=scan.next();

				int sum=0;
				for(int i=0;i<num;i++) {
					if(k1.equals(st[i].name)) {
						for(int j=0;j<subject_num;j++) {
							sum+=subject_score[i*subject_num+j];
						}
					}
				}
				System.out.println("성적 평균 :"+sum/subject_num);
			}
			
				

		}


	}
}
