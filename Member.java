package ksnu.a1901070.array;

import java.util.*;

public class Member {
	String[] strArr=new String[100];
	int index=-1;
	int count=0;
	
	public void add(String data) {
		strArr[count]=data;
		count++;
	}
	
	public void printAll() {
		for(int i=0;i<count;i++) {
			System.out.print(strArr[i]+"   ");
		}
		System.out.println();
	}
	
	public int indexOf(String data) {
        for(int i=0;i<count;i++) {
        	if(strArr[i].equals(data)) {
        		return i; 
        		}
        }
        return -1; // 찾는 데이터가 없으면 -1 리턴
    }

    public void update(int index, String data) {
         // 코드를 작성하세요.
    	
    	strArr[index]=data;
    }

    public String delete(int index) {
        String deletedData = strArr[index];
        // 코드를 작성하세요.
        
        for(int i=index;i<count;i++) {
        	strArr[i-1]=strArr[i];
        }
        count--;
        return deletedData;
    }

    public void insert(int index, String data) {
        // 코드를 작성하세요.
    	for(int i=count-1;i>=index;i--) {
    		strArr[i+1]=strArr[i];
    	}
    	strArr[index]=data;
        count++;
    }

	
	public static void main(String args[]) {
		Member ex = new Member();
		
		 ex.add("홍길동");
		 ex.add("김영희");
		 ex.add("송유라");
		 ex.add("박철수");
		 ex.add("이영수");
		 ex.printAll();
		 System.out.println("회원 박철수의 인덱스는 " + ex.indexOf("박철수"));

		 ex.update(2, "한소희");
		 ex.printAll();

		 System.out.println(ex.delete(1) + "데이터를 삭제합니다.");
		 ex.printAll();

		 ex.insert(1, "차승원");
		 ex.printAll();

		 ex.insert(2, "주은영");
		 ex.printAll();

	}
}
