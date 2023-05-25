package homework;

import java.util.Scanner;

class Circle1{
	private double x,y;
	private int radius;
	public Circle1(double x, double y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public double setX() {
		return this.x;
	}
	public double setY() {
		return this.y;
	}
	public int setRadius() {
		return this.radius;
	}
}

public class num6 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Circle1 c[]=new Circle1[3];
		int maxIndex=0;
		int maxValue=0;
		
		for(int i=0;i<c.length;i++) {
			System.out.print("x, y, radius >>");
			double x=scan.nextDouble();
			double y=scan.nextDouble();
			int radius=scan.nextInt();
			c[i]=new Circle1(x,y,radius);
			if(maxValue<radius) {
				maxValue=radius;
				maxIndex=i;
			}
		}
		
		System.out.println("가장 면적이 큰 원은 ("+c[maxIndex].setX()+","+c[maxIndex].setY()+")"+c[maxIndex].setRadius());
	}
}
