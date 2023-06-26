package lastExam;

import java.util.Comparator;

public class getBikeName implements Comparator<bicycle>{

	@Override
	public int compare(bicycle o1, bicycle o2) {
		// TODO Auto-generated method stub
		return o1.getBikeName().compareTo(o2.getBikeName());
	}
	
}
