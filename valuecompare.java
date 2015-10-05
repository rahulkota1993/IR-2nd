package assignment2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class valuecompare implements Comparator<String>{
	HashMap<String,Integer> hmp;

	 public valuecompare(HashMap<String, Integer> temp) {
		// TODO Auto-generated constructor stub
		 this.hmp=temp;
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(hmp.get(o1)>=hmp.get(o2)){
			return -1;
		}else{
			return 1;
		}
	}

	
	
}
