package assignment2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class sortingmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ref: http://www.programcreek.com/2013/03/java-sort-map-by-value/
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		hm.put("rahul", 12);
		hm.put("sunny", 16);
		hm.put("hmmm", 18);
		hm.put("raw", 12);
		hm.put("hero", 15);
		
		valuecompare vc=new valuecompare(hm);
		TreeMap<String, Integer> tm=new TreeMap<String, Integer>(vc);
		tm.putAll(hm);
		
		System.out.println(tm);
		System.out.println(hm);
		}
}
