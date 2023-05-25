package homework;

import java.util.Scanner;

class calculater{
	private int a;
	private int b;
	private String c;
	
	public int getA() {
		return this.a;
	}
	public int getB() {
		return this.b;
	}
	
	public void setValue(int a,int b) {
		this.a=a;
		this.b=b;
	}
	
	public void setC(String c) {
		this.c=c;
	}
	
	public int calculate() {
		int result =0;
		if(this.c.equals("+")) result =this.a+this.b;
		else if(this.c.equals("-"))result =this.a-this.b;
		else if(this.c.equals("*"))result =this.a*this.b;
		else if(this.c.equals("/"))result =this.a/this.b;
		return result;
	}
}

public class num11 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a,b;
		String c;
		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		a=scan.nextInt();
		b=scan.nextInt();
		c=scan.next();
		
		calculater cal=new calculater();
		cal.setValue(a,b);
		cal.setC(c);
		
		System.out.println(cal.calculate());
	}
}
