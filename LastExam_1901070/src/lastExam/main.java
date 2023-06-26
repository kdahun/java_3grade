package lastExam;

import java.util.*;
import java.io.*;

public class main {
	static void menu() {
		System.out.println("0. 가입자 로그인(초기admin/pass : root/1234");
		System.out.println("1. 신규 가입자 정보 입력      2. 가입자 리스트 보기");
		System.out.println("3. free 가입자 리스트만 보기");
		System.out.println("4. 대여 자전거 데이터 입력     5. 대여자전거 리스트 보기");
		System.out.println("6. 자전거 대여 정보 수정      7. 대여자전거 정보 삭제");
		System.out.println("8.. 종료");
	}
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int stop = -1;
		String id;
		String pass;
		String name;
		String type;
		
		String bikeId;
		String bikeName;
		String bikeRenter;
		int bikeCost;
		
		ArrayList<subscriber> subArray= new ArrayList<>();
		ArrayList<bicycle> bikeArray= new ArrayList<>();
		
		while(stop!=8) {
			menu();
			stop=0;
			try {
				stop=scan.nextInt();
			}catch(Exception e) {
				scan.next();
				continue;
			}
			
			
			switch(stop) {
			case 0:
				int stack=0;
				System.out.print("id : ");
				id = scan.next();
				System.out.print("pass : ");
				pass = scan.next();
				if("root1234".equals(id+pass)) {
					System.out.println("root 님 반갑습니다.");
				}
				try {
					FileReader fRead = new FileReader("subscribers.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					subArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						subArray.add(new subscriber(a[0], a[1], a[2],a[3]));
					}
					for(subscriber i : subArray) {
						String addIdPass = i.getId()+i.getPass();
						if(addIdPass.equals(id+pass)) {
							System.out.println(i.getName()+"님 반갑습니다.");
							break;
						}
						stack++;
					}
					bRead.close();
					fRead.close();
					if(stack==subArray.size()) {
						System.out.println("id 또는 password가 틀립니다. 다시 시도!");
					}
					
				}catch(IOException e) {
					
					try {
						FileWriter fWrite = new FileWriter("subscribers.dat");
						fWrite.write("root root 1234 admin\r\n");
						fWrite.close();
						
					}catch(IOException e1) {
						
					}
				}
				
				break;
			case 1:
				try {
					System.out.println("세부사항 입력 : ");
					id = scan.next();
					name = scan.next();
					pass = scan.next();
					type = scan.next();
					
					FileWriter fWrite = new FileWriter("subscribers.dat",true);
					fWrite.write(id+" "+name+" "+pass+" "+type+"\r\n");
					fWrite.close();
					System.out.println("입력 완료");
					
				}catch(IOException e1) {
					
				}
				break;
			case 2:
				try {
					FileReader fRead = new FileReader("subscribers.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					subArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						subArray.add(new subscriber(a[0], a[1], a[2],a[3]));
					}
					
					Collections.sort(subArray);
					System.out.println("번호\tid\t이름\t패스워드\t회원종류");
					for(int i=0;i<subArray.size();i++) {
						System.out.println((i+1)+"\t"+subArray.get(i).getId()+"\t"+subArray.get(i).getName()+
								"\t"+subArray.get(i).getPass()+"\t"+subArray.get(i).getType());
					}
					bRead.close();
					fRead.close();
					
				}catch(IOException e) {
					
				}
				break;
			case 3:
				try {
					FileReader fRead = new FileReader("subscribers.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					subArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						subArray.add(new subscriber(a[0], a[1], a[2],a[3]));
					}
					
					Collections.sort(subArray);
					System.out.println("번호\tid\t이름\t패스워드\t회원종류");
					int stack2=0;
					for(int i=0;i<subArray.size();i++) {
						if("free".equals(subArray.get(i).getType())) {
							stack2++;
							System.out.println(stack2+"\t"+subArray.get(i).getId()+"\t"+subArray.get(i).getName()+
									"\t"+subArray.get(i).getPass()+"\t"+subArray.get(i).getType());	
						}
					}
					bRead.close();
					fRead.close();
					
				}catch(IOException e) {
					
				}
				break;
			case 4:
				try {
					System.out.println("세부사항 입력 : ");
					bikeId = scan.next();
					bikeName = scan.next();
					bikeRenter = scan.next();
					bikeCost = scan.nextInt();
					
					FileWriter fWrite = new FileWriter("bicycledb.dat",true);
					fWrite.write(bikeId+" "+bikeName+" "+bikeRenter+" "+bikeCost+"\r\n");
					fWrite.close();
					System.out.println("입력 완료");
					
				}catch(IOException e1) {
					
				}
				break;
			case 5:
				System.out.println("1) id 순 보기");
				System.out.println("2) 대겨가격 순 보기");
				System.out.print("선택 : ");
				int sw=scan.nextInt();
				
				try {
					FileReader fRead = new FileReader("bicycledb.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					bikeArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						bikeArray.add(new bicycle(a[0], a[1], a[2],Integer.parseInt(a[3])));
					}
					bRead.close();
					fRead.close();
					
				}catch(IOException e) {
					
				}
				
				if(sw==1) {
					Collections.sort(bikeArray,new getBicycleId());
					System.out.println("번호\t자전거id\t모델\t대여가입자\t대여가격");
					for(int i=0;i<bikeArray.size();i++) {
						System.out.println((i+1)+"\t"+bikeArray.get(i).getBikeId()+"\t"+bikeArray.get(i).getBikeName()+
								"\t"+bikeArray.get(i).getBikeRenter()+"\t"+bikeArray.get(i).getBikeCost());
					}
				}
				else if(sw==2) {
					Collections.sort(bikeArray,new getBicycleCost());
					System.out.println("번호\t자전거id\t모델\t대여가입자\t대여가격");
					for(int i=0;i<bikeArray.size();i++) {
						System.out.println((i+1)+"\t"+bikeArray.get(i).getBikeId()+"\t"+bikeArray.get(i).getBikeName()+
								"\t"+bikeArray.get(i).getBikeRenter()+"\t"+bikeArray.get(i).getBikeCost());
					}
				}else {
					System.out.println("1과 2만 입력");
				}
				break;
			case 6:
				try {
					FileReader fRead = new FileReader("bicycledb.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					bikeArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						bikeArray.add(new bicycle(a[0], a[1], a[2],Integer.parseInt(a[3])));
					}
					bRead.close();
					fRead.close();
					
				}catch(IOException e) {
					
				}
				Collections.sort(bikeArray,new getBicycleId());
				System.out.println("번호\t자전거id\t모델\t대여가입자\t대여가격");
				for(int i=0;i<bikeArray.size();i++) {
					System.out.println((i+1)+"\t"+bikeArray.get(i).getBikeId()+"\t"+bikeArray.get(i).getBikeName()+
							"\t"+bikeArray.get(i).getBikeRenter()+"\t"+bikeArray.get(i).getBikeCost());
				}
				
				System.out.print("번호 선택 :");
				int selectNum = scan.nextInt();
				for(int i=0;i<bikeArray.size();i++) {
					if(selectNum==i+1) {
						System.out.print("세부사항 입력 : ");
						bikeId = scan.next();
						bikeName = scan.next();
						bikeRenter = scan.next();
						bikeCost = scan.nextInt();
						bikeArray.set(i, new bicycle(bikeId, bikeName, bikeRenter, bikeCost));
					}
				}
				try {
					FileWriter fWrite = new FileWriter("bicycledb.dat");
					fWrite.close();
					
				}catch(IOException e1) {
					
				}
				for(bicycle i : bikeArray) {
					try {
						bikeId = i.getBikeId();
						bikeName = i.getBikeName();
						bikeRenter = i.getBikeRenter();
						bikeCost = i.getBikeCost();
						
						FileWriter fWrite = new FileWriter("bicycledb.dat",true);
						fWrite.write(bikeId+" "+bikeName+" "+bikeRenter+" "+bikeCost+"\r\n");
						fWrite.close();
						System.out.println("수정 완료");
						
					}catch(IOException e1) {
						
					}
				}
				break;
			case 7:
				try {
					FileReader fRead = new FileReader("bicycledb.dat");
					BufferedReader bRead = new BufferedReader(fRead);
					bikeArray=new ArrayList<>();
					String line="";
					while((line=bRead.readLine())!=null) {
						String a[] = line.split(" ");
						bikeArray.add(new bicycle(a[0], a[1], a[2],Integer.parseInt(a[3])));
					}
					bRead.close();
					fRead.close();
					
				}catch(IOException e) {
					
				}
				Collections.sort(bikeArray,new getBicycleId());
				System.out.println("번호\t자전거id\t모델\t대여가입자\t대여가격");
				for(int i=0;i<bikeArray.size();i++) {
					System.out.println((i+1)+"\t"+bikeArray.get(i).getBikeId()+"\t"+bikeArray.get(i).getBikeName()+
							"\t"+bikeArray.get(i).getBikeRenter()+"\t"+bikeArray.get(i).getBikeCost());
				}
				
				System.out.print("번호 선택 :");
				int selectNum1 = scan.nextInt();
				for(int i=0;i<bikeArray.size();i++) {
					if(selectNum1==i+1) {
						bikeArray.remove(i);
					}
				}
				try {
					FileWriter fWrite = new FileWriter("bicycledb.dat");
					fWrite.close();
					
				}catch(IOException e1) {
					
				}
				for(bicycle i : bikeArray) {
					try {
						bikeId = i.getBikeId();
						bikeName = i.getBikeName();
						bikeRenter = i.getBikeRenter();
						bikeCost = i.getBikeCost();
						
						FileWriter fWrite = new FileWriter("bicycledb.dat",true);
						fWrite.write(bikeId+" "+bikeName+" "+bikeRenter+" "+bikeCost+"\r\n");
						fWrite.close();
						System.out.println("삭제 완료");
						
					}catch(IOException e1) {
						
					}
				}
			}
				
		}
		System.out.println("프로그램 종료!");
	}
}
