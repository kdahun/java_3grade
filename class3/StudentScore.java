package ksnu.a0000001.class3;

import java.util.Scanner;

public class StudentScore {
	
	public void printMenu() {
		System.out.println();
		System.out.println("<성적처리 프로그램>");
		System.out.println("1.학생 정보 입력하기");
		System.out.println("2.학생 정보 보기");
		System.out.println("3.과목 입력하기");
		System.out.println("4.성적 입력하기");
		System.out.println("5.성적 보기");
		System.out.println("6.성적 수정하기");
		System.out.println("7.평균 성적보기");
		System.out.println("0.메인메뉴 돌아가기");
		System.out.println("9.프로그램 종료");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		StudentScore ss = new StudentScore();
		
		ss.printMenu();
		int menuNum = scanner.nextInt();
		
		// 학생 수
		int stdCnt = 0;
		// 과목 수
		int sbjCnt = 0;
		
		// 학생 정보 배열
		Student[] stdArr = null;
		
		// 학생 정보 변수
		String sName = null;
		String sNum = null;
		String phone = null;
		
		// 과목 정보 배열
		String[] sbjArr = null;
		
		String temp = "";
		
		int isShutdown = 1;
		while (isShutdown > 0) {
			while (menuNum >= 0) {
				switch (menuNum) {
				case 0:
					ss.printMenu();
					menuNum = scanner.nextInt();
					
					break;
				case 1:
					System.out.print("몇 명의 학생 정보를 입력하시겠습니까 > ");
					stdCnt = scanner.nextInt();
					
					stdArr = new Student[stdCnt];
					for (int i=0; i<stdCnt; i++) {
						System.out.print("이름 > ");
						sName = scanner.next();
						
						System.out.print("학번 > ");
						sNum = scanner.next();
						
						System.out.print("전화번호 > ");
						phone = scanner.next();
						
						stdArr[i] = new Student(sName, sNum, phone);
					}
					
					if (sbjArr != null) {						
						for (int i=0; i<stdCnt; i++) {
							stdArr[i].createSbjArr(sbjCnt);
							Subject[] tempArr = stdArr[i].getSbjArr();
							
							for (int j=0; j<sbjCnt; j++) {
								tempArr[j] = new Subject(sbjArr[j], 0);
							}
						}
					}
					
					menuNum = 0;
					break;
				case 2:
					System.out.println("학생 정보 보기");
					
					if (stdArr != null) {			
						System.out.print("학생 선택(이름) > ");
						sName = scanner.next();
						
						if (sName.equals("0")) {
							menuNum = 0;
							
							break;
						}
						
						boolean isStd = false;						
						for (int i=0; i<stdArr.length; i++) {
							if (stdArr[i].getName().equals(sName)) {
								System.out.println("이름 : " + stdArr[i].getName());
								System.out.println("학번 : " + stdArr[i].getStdNo());
								System.out.println("전화번호 : " + stdArr[i].getPhone());
							
								isStd = true;
							}							
						}	
						
						if (!isStd) {
							System.out.println();
							System.out.println("*** 입력한 이름의 학생이 없습니다. ***");
							System.out.println();
							
							menuNum = 0;
						}
					} else {
						System.out.println();
						System.out.println("*** 학생 정보가 없습니다. 학생 정보를 먼저 입력하세요. ***");
						System.out.println();
						menuNum = 0;
					}
					
					break;
				case 3:
					System.out.println("과목 입력하기");
					System.out.print("과목 개수 > ");
					sbjCnt = scanner.nextInt();
					
					System.out.print("과목 이름 > ");
					
					sbjArr = new String[sbjCnt];
					
					for (int i=0; i<sbjCnt; i++) {
						temp = scanner.next();
						sbjArr[i] = temp; 
					}
					
					if (stdArr != null) {					
						for (int i=0; i<stdCnt; i++) {
							stdArr[i].createSbjArr(sbjCnt);
							Subject[] tempArr = stdArr[i].getSbjArr();
							
							for (int j=0; j<sbjCnt; j++) {
								tempArr[j] = new Subject(sbjArr[j], 0);
							}							
						}
					}
					
					
					menuNum = 0;
					break;
				case 4:
					System.out.println("성적 입력하기");
					
					if (stdArr != null) {
						System.out.print("학생 선택(이름) > ");						
						sName = scanner.next();
						
						if (sName.equals("0")) {
							menuNum = 0;
							
							break;
						}
						
						boolean isStd = false;						
						for (int i=0; i<stdArr.length; i++) {
							if (stdArr[i].getName().equals(sName)) {
								if (sbjArr != null) {
									System.out.print("성적 입력 : ");
								
									Subject[] tempArr = stdArr[i].getSbjArr();
									for (int j=0; j<sbjCnt; j++) {										
										tempArr[j].setScore(scanner.nextInt()); 
									}
								} else {
									System.out.println();
									System.out.println("*** 과목 정보가 없습니다. 과목 정보를 입력하세요. ***");
									System.out.println();
									menuNum = 0;
								}
								
								isStd = true;
							}							
						}
						
						if (!isStd) {
							System.out.println();
							System.out.println("*** 입력한 이름의 학생이 없습니다. ***");
							System.out.println();
							
							menuNum = 0;
						}
					} else {
						System.out.println();
						System.out.println("*** 학생 정보가 없습니다. 학생 정보를 먼저 입력하세요. ***");
						System.out.println();
						menuNum = 0;
					}
					
					menuNum = 0;
					break;
				case 5:
					System.out.println("성적 보기");		
					
					if (sbjArr != null) {
						System.out.print("index");
						for (int i=0; i<sbjCnt; i++) {							
							System.out.print("\t" + sbjArr[i]);							
						}
						System.out.println();
						
						if (stdArr != null) {
							for (int i=0; i<stdCnt; i++) {
								System.out.print(stdArr[i].getName());
								Subject[] tempArr = stdArr[i].getSbjArr();
								
								for (int j=0; j<sbjCnt; j++) {
									System.out.print("\t" + tempArr[j].getScore());
								}
								System.out.println();
							}
						} else {
							System.out.println();
							System.out.println("*** 학생 정보가 없습니다. 학생 정보를 입력하세요. ***");
							System.out.println();
							menuNum = 0;
						}					
					} else {
						System.out.println();
						System.out.println("*** 과목 정보가 없습니다. 과목 정보를 입력하세요. ***");
						System.out.println();
						menuNum = 0;
					}
					
					menuNum = 0;
					break;
				case 6:
					System.out.println("성적 수정하기");	
					
					if (stdArr != null) {
						System.out.print("학생 선택(이름) > ");						
						sName = scanner.next();
						
						if (sName.equals("0")) {
							menuNum = 0;
							
							break;
						}
						
						boolean isStd = false;						
						for (int i=0; i<stdArr.length; i++) {
							if (stdArr[i].getName().equals(sName)) {
								Subject[] tempArr = stdArr[i].getSbjArr();
								
								if (tempArr != null) {
									System.out.print("현재 성적 : ");
									for (int j=0; j<sbjCnt; j++) {
										System.out.print(" " + tempArr[j].getScore());										 
									}
									System.out.println();
									
									System.out.print("새로운 성적 : ");
									for (int j=0; j<sbjCnt; j++) {										
										tempArr[j].setScore(scanner.nextInt()); 
									}
									System.out.println();
								} else {
									System.out.println();
									System.out.println("*** 과목 정보가 없습니다. 과목 정보를 입력하세요. ***");
									System.out.println();
									menuNum = 0;
								}
								
								isStd = true;
							}							
						}
						
						if (!isStd) {
							System.out.println();
							System.out.println("*** 입력한 이름의 학생이 없습니다. ***");
							System.out.println();
							
							menuNum = 0;
						}
					} else {
						System.out.println();
						System.out.println("*** 학생 정보가 없습니다. 학생 정보를 먼저 입력하세요. ***");
						System.out.println();
						menuNum = 0;
					}
					
					menuNum = 0;
					break;			
				case 7:
					System.out.println("평균 성적보기");	
					
					if (stdArr != null) {
						System.out.print("학생 선택(이름) > ");						
						sName = scanner.next();
						
						if (sName.equals("0")) {
							menuNum = 0;
							
							break;
						}
						
						boolean isStd = false;						
						for (int i=0; i<stdArr.length; i++) {
							if (stdArr[i].getName().equals(sName)) {
								Subject[] tempArr = stdArr[i].getSbjArr();
								
								if (tempArr != null) {
									System.out.print("성적 평균 : ");
									int sum = 0;
									for (int j=0; j<sbjCnt; j++) {
										sum += tempArr[j].getScore();										 
									}
									System.out.println((double)sum/(double)sbjCnt + " 점");									
								} else {
									System.out.println();
									System.out.println("*** 과목 정보가 없습니다. 과목 정보를 입력하세요. ***");
									System.out.println();
									menuNum = 0;
								}
								
								isStd = true;
							}							
						}
						
						if (!isStd) {
							System.out.println();
							System.out.println("*** 입력한 이름의 학생이 없습니다. ***");
							System.out.println();
							
							menuNum = 0;
						}
					} else {
						System.out.println();
						System.out.println("*** 학생 정보가 없습니다. 학생 정보를 먼저 입력하세요. ***");
						System.out.println();
						menuNum = 0;
					}
					
					menuNum = 0;					
					break;
				case 9:
					menuNum = -1;
					isShutdown = 0;
					scanner.close();
					break;				
				}
			}
		}
		
		System.out.println("***  프로그램을 종료합니다. 수고하셨습니다. ***");
		
	}

}
