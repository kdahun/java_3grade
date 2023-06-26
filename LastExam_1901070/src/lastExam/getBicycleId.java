package lastExam;

import java.util.Comparator;

public class getBicycleId implements Comparator<bicycle>{

	@Override
	public int compare(bicycle o1, bicycle o2) {
		
		return o1.getBikeId().compareTo(o2.getBikeId());
	}

}
