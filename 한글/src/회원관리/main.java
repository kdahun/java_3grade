package 회원관리;

import java.util.Scanner;


import java.io.*;

public class main {

	static public void printMenu() {
		System.out.println("1. 로그인");
		System.out.println("2. 신규회원가입");
		System.out.println("3. 회원정보보기");
		System.out.println("4. 종료");

	}

	public static void main(String args[]) {
		int stop = 0;
		Scanner scan = new Scanner(System.in);
		person p[]=null;


		int size=0;
		int count=0;
		String id,name,pass;

		while(stop!=4) {
			printMenu();
			stop = scan.nextInt();
			switch(stop) {
			case 1:
				id = scan.next();
				pass = scan.next();

				try {
					FileWriter write = new FileWriter("subscribers.txt",true);
					write.write("1\r\n");
					write.write("root root 1234\r\n");
					write.close();

				}catch(IOException e){

				}

				try {
					FileReader reader = new FileReader("subscribers.txt");
					BufferedReader read = new BufferedReader(reader);
					String line =read.readLine();
					count = Integer.parseInt(line);
					if(count>0) {
						p = new person[count];
					}

					for(int i=0;i<count;i++) {
						line =read.readLine();
						if(line == null) break;
						String arr[]=new String[3];
						arr=line.split(" ");
						p[i]=new person(arr[0],arr[1],arr[2]);

					}
					//reader.read()
				}catch(IOException e) {

				}

				for(person i:p) {
					if(i.getId().equals(id) && i.getPass().equals(pass)) {
						System.out.println("=>"+i.getName()+"님 반갑습니다");
					}
				}

				break;
			case 2:
				
				break;
			case 3:

				break;
			case 4:
				System.out.println("종료");
			}
		}
	}
}
