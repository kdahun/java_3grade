package ksnu.a1901070.score;

public class Subject {
	int ko[] = new int[100];
	int count=0;
	
	
	
	public int[] getKo(int num) {
		for(int i=0;i<num;i++) {
			ko[i]=num;
		}
		return ko;
	}
	public void setKo(int ko,int num) {
		this.ko[num] = ko;
	}
}
