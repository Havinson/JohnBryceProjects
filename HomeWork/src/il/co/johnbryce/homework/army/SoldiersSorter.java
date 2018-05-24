package il.co.johnbryce.homework.army;

import java.util.Comparator;

public class SoldiersSorter implements Comparator<EnlistedSoldier> {

	@Override
	public int compare(EnlistedSoldier o1, EnlistedSoldier o2) {
		if(o1.getMinimumTime() > o2.getMinimumTime()) {
			return 1;
		}else if(o1.getMinimumTime() < o2.getMinimumTime()) {
			return -1;
		}
		return 0;
	}//compare

}//SoldiersSorter
