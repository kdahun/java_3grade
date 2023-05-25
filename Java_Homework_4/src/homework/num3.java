package homework;

import java.util.Scanner;

class Song{
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song() {
		
	}
	public Song(String title, String artist, int year,String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	public void show() {
		System.out.println(this.year+"년 "+this.country+"국적의 "+this.artist+"가 부른 "+this.title);
	}
}

public class num3 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("제목, 가수, 년도, 국적 순으로 입력 >>");
		
		String title = scan.next();
		String artist = scan.next();
		int year = scan.nextInt();
		String country=scan.next();
		
		
		Song s=new Song(title,artist,year,country);
		
		s.show();
		
		scan.close();
	}
}
