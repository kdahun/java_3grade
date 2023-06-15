package 회원관리2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import java.io.*;

public class main {

	static public void printMenu() {
		System.out.println("1. 로그인");
		System.out.println("2. 신규회원가입");
		System.out.println("3. 회원정보보기");
		System.out.println("4. 종료");

	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		//person p[]=null;
		ArrayList<person> p1=null;
		
		
		int stop = 0;
		String id,name,pass;

		while(stop!=4) {
			printMenu();
			stop = scan.nextInt();
			switch(stop) {
			case 1:
				id = scan.next();
				pass = scan.next();

				try {
					FileReader reader2 = new FileReader("subscribers.txt");					
					BufferedReader read2 = new BufferedReader(reader2);

					p1 = new ArrayList<person>();
					while(true){
						String line =read2.readLine();
						if(line == null) break;
						String arr[]=new String[3];
						arr=line.split(" ");
						p1.add(new person(arr[0],arr[1],arr[2]));

					}
					System.out.println(p1.size());
					for(int i=0;i<p1.size();i++) {
						if(p1.get(i).getId().equals(id) && p1.get(i).getPass().equals(pass)) {
							System.out.println("=>"+p1.get(i).getName()+"님 반갑습니다");
						}
					}

					//reader.read()
				}catch(IOException e) {
					try {
						FileWriter write = new FileWriter("subscribers.txt",true);
						write.write("root root 1234\r\n");
						System.out.println("=>root 님 반갑습니다");
						write.close();

					}catch(IOException e1){

					}
				}

				
				break;
			case 2:
				
				
				try {
					id = scan.next();
					name = scan.next();
					pass = scan.next();
					FileWriter write = new FileWriter("subscribers.txt",true);
					write.write(id+" "+name+" "+pass+"\r\n");
					write.close();

				}catch(IOException e){
					
				}
				break;
			case 3:
				try {
					FileReader reader2 = new FileReader("subscribers.txt");					
					BufferedReader read2 = new BufferedReader(reader2);
					p1 = new ArrayList<person>();
					while(true){
						String line =read2.readLine();
						if(line == null) break;
						String arr[]=new String[3];
						arr=line.split(" ");
						p1.add(new person(arr[0],arr[1],arr[2]));

					}
					
					Collections.sort(p1);
					for(int i=0;i<p1.size();i++) {
						System.out.println(p1.get(i).getId()+" "+p1.get(i).getName()+" "+p1.get(i).getPass());
					}
					
				}catch(IOException e) {
					
				}
				break;
			case 4:
				System.out.println("종료");
			}
		}
	}
}
