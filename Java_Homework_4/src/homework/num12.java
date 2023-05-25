package homework;

import java.util.Scanner;


class seatSAB{
	private String S[];
	private String A[];
	private String B[];
	
	public seatSAB() {
		S=new String[10];
		A=new String[10];
		B=new String[10];
		
		for(int i=0;i<10;i++) {
			S[i]="---";
			A[i]="---";
			B[i]="---";
		}
	}

	public String[] getS() {
		return S;
	}

	public void setS(String[] s) {
		S = s;
	}

	public String[] getA() {
		return A;
	}

	public void setA(String[] a) {
		A = a;
	}

	public String[] getB() {
		return B;
	}

	public void setB(String[] b) {
		B = b;
	}
}

public class num12 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		seatSAB seat=new seatSAB();
		
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		
		int stop=0;
		while(stop!=4) {
			System.out.print("예약 : 1, 조회 : 2, 취소 : 3, 끝내기 : 4 >> ");
			stop=scan.nextInt();
			switch(stop) {
			case 1:
				System.out.print("좌석구분 S(1),A(2),B(3) >> ");
				int seatNum=scan.nextInt();
				if(seatNum==1) {
					String array1[] = seat.getS();
					System.out.print("S>> ");
					for(int i=0;i<array1.length;i++) {
						System.out.print(array1[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String nameS=scan.next();
					System.out.print("번호 >> ");
					int numS=scan.nextInt();
					array1[numS-1]=nameS;
				}
				
				else if(seatNum==2) {
					String array2[] = seat.getA();
					System.out.print("A>> ");
					for(int i=0;i<array2.length;i++) {
						System.out.print(array2[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String nameA=scan.next();
					System.out.print("번호 >> ");
					int numA=scan.nextInt();
					array2[numA-1]=nameA;
				}
				
				else if(seatNum==3) {
					String array3[] = seat.getB();
					System.out.print("B>> ");
					for(int i=0;i<array3.length;i++) {
						System.out.print(array3[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String nameB=scan.next();
					System.out.print("번호 >> ");
					int numB=scan.nextInt();
					array3[numB-1]=nameB;
				}
				break;
			case 2:
				String arrayS[]=seat.getS();
				String arrayA[]=seat.getA();
				String arrayB[]=seat.getB();
				
				System.out.print("S >> ");
				for(int i=0;i<arrayS.length;i++) {
					System.out.print(arrayS[i]+" ");
				}
				System.out.println();
				
				System.out.print("A >> ");
				for(int i=0;i<arrayA.length;i++) {
					System.out.print(arrayA[i]+" ");
				}
				System.out.println();
				
				System.out.print("B >> ");
				for(int i=0;i<arrayB.length;i++) {
					System.out.print(arrayB[i]+" ");
				}
				System.out.println();
				
				System.out.println("<<<<조회를 완료하였습니다.>>>>");
				break;
			case 3:
				System.out.print("좌석 S:1, A:2, B:3 >>");
				int cancelNum=scan.nextInt();
				if(cancelNum==1) {
					String cArrayS[]=seat.getS();
					System.out.print("S >> ");
					for(int i=0;i<cArrayS.length;i++) {
						System.out.print(cArrayS[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String cNameS=scan.next();
					for(int i=0;i<cArrayS.length;i++) {
						if(cNameS.equals(cArrayS[i]))cArrayS[i]="---";
					}
				}
				
				else if(cancelNum==2) {
					String cArrayA[]=seat.getA();
					System.out.print("A >> ");
					for(int i=0;i<cArrayA.length;i++) {
						System.out.print(cArrayA[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String cNameA=scan.next();
					for(int i=0;i<cArrayA.length;i++) {
						if(cNameA.equals(cArrayA[i]))cArrayA[i]="---";
					}
				}
				
				else if(cancelNum==3) {
					String cArrayB[]=seat.getB();
					System.out.print("B >> ");
					for(int i=0;i<cArrayB.length;i++) {
						System.out.print(cArrayB[i]+" ");
					}
					System.out.println();
					
					System.out.print("이름 >> ");
					String cNameB=scan.next();
					for(int i=0;i<cArrayB.length;i++) {
						if(cNameB.equals(cArrayB[i]))cArrayB[i]="---";
					}
				}
			}
		}
		
		
		
	}
}
