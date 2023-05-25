package homework;

class Rectangle{
	private int x,y,width,height;
	
	public Rectangle(int x,int y,int w,int h) {
		this.x=x;
		this.y=y;
		this.width=w;
		this.height=h;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getW() {
		return this.width;
	}
	public int getH() {
		return this.height;
	}
	
	public void show() {
		System.out.println("("+this.x+","+this.y+")에서 크기가 "+this.width+"x"+this.height+"인 사각형");
	}
	
	public int square() {
		int result=0;
		result=this.height*this.width;
		
		return result;
	}
	
	public boolean contanins(Rectangle s) {
		int x=s.getX();
		int y=s.getY();
		int w=s.getW();
		int h=s.getH();
		
		//x~x+w y~y+h
		if((this.x-this.width/2)>x||(this.x+this.width/2)<x+w/2) {
			return false;
		}
		if((this.y-this.height/2)>y||(this.y+this.height/2)<y+h/2) {
			return false;
		}
		
		return true;
	}
}

public class num4 {
	public static void main(String args[]) {
		Rectangle r= new Rectangle(2,2,8,7);
		Rectangle s=new Rectangle(5,5,6,6);
		Rectangle t=new Rectangle(1,1,10,10);
		
		r.show();
		System.out.println("s의 면적은 "+s.square());
		if(t.contanins(r))System.out.println("t는 r을 포함합니다.");
		if(t.contanins(s))System.out.println("t는 s을 포함합니다.");
	}
}
