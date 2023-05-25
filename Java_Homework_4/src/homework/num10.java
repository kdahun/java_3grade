package homework;

import java.util.Scanner;

class Dictionary{
	private static String[] kor= {"사랑","아기","돈","미래","희망"};
	private static String[] eng= {"love","baby","money","future","hope"};
	
	public static String kor2Eng(String word) {
		String enn=" ";
		for(int i=0;i<kor.length;i++) {
			if(word.equals(kor[i])) {
				enn=eng[i];
				break;
			}
		}
		
		return enn;
	}
}

public class num10 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("한영 단어 검색 프로그램입니다.");
		
		String stop=" ";
		while(!stop.equals("그만")) {
			System.out.print("한글 단어? ");
			stop=scan.next();
			String result = Dictionary.kor2Eng(stop);
			if(stop.equals("그만")) break;
			if(result.equals(" ")) {
				System.out.println(stop+"는 저의 사전에 없습니다.");
			}
			else System.out.println(stop+"은 "+result);
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
