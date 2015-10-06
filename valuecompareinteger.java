package assignment2;

import java.util.Comparator;
import java.util.HashMap;

public class valuecompareinteger implements Comparator<Integer> {
	HashMap<Integer,Integer> hmp2;

	public valuecompareinteger(HashMap<Integer, Integer> temp2) {
		// TODO Auto-generated constructor stub
		 hmp2=temp2;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(hmp2.get(o1)>=hmp2.get(o2)){
			return -1;
		}else{
			return 1;
		}
	}


}
