package lastExam;

import java.util.Comparator;

public class getBicycleCost implements Comparator<bicycle>{

	@Override
	public int compare(bicycle o1, bicycle o2) {
		
		return o1.getBikeCost()-o2.getBikeCost();
	}

}
