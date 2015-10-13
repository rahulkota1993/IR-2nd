package assignment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class TAAT {
	String staat;
	HashMap<String, LinkedList<String>> hmtaat;
	String[] staatarray;
	public TAAT(String s,HashMap<String, LinkedList<String>> sl){
		staat=s;
		hmtaat=sl;
		staatarray=staat.split(" ");
//		stringarraycomparator scp=new stringarraycomparator(hmtaat);
//		Arrays.sort(staatarray, scp);
//		for(String temp:staatarray){
//			System.out.println(temp+" :"+hmtaat.get(temp));
//			
//		}
	}
	public LinkedList<String> TAATand(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		LinkedList <String> staatlist=new LinkedList<String>();
		int comparisions=0;
		tempstore=(LinkedList<String>) hmtaat.get(staatarray[0]).clone();
//		result=(LinkedList<String>) tempstore.clone();
		if(staatarray.length==1){
		result=(LinkedList<String>) tempstore.clone();
		}
		
		String t;
		for(int i=1;i<staatarray.length;i++){
			ListIterator<String> itr1=tempstore.listIterator();			
			staatlist=(LinkedList<String>) hmtaat.get(staatarray[i]).clone();
			
			while(itr1.hasNext()){
				t=itr1.next();				
				ListIterator<String> itr2inner=staatlist.listIterator();
				while(itr2inner.hasNext()){
					comparisions=comparisions+1;
					if(t.equals(itr2inner.next())){
						result.add(t);
						//System.out.println("staat :"+staat);
						itr2inner.remove();
						//System.out.println("staat after :"+staat);
						break;
						
					}
					
				}
			}
			
			tempstore=(LinkedList<String>) result.clone();
			
			if(result.isEmpty()){
				System.out.println("null");
				break;
			}
			result.clear();
		}		
		System.out.println("Comparisions:"+comparisions);
		return tempstore;
	}
public LinkedList<String> TAATor(){
	LinkedList<String> result=new LinkedList<String>();
	LinkedList<String> tempstore=new LinkedList<String>();
	LinkedList <String> staat=new LinkedList<String>();
	int comparisions=0;

	tempstore=(LinkedList<String>) hmtaat.get(staatarray[0]).clone();
	System.out.println("tempstore :"+tempstore);
//	result=(LinkedList<String>) tempstore.clone();
	if(staatarray.length==1){
	result=(LinkedList<String>) tempstore.clone();
	}
	
	String t;
	for(int i=1;i<staatarray.length;i++){
		ListIterator<String> itr1=tempstore.listIterator();			
		staat=(LinkedList<String>) hmtaat.get(staatarray[i]).clone();
		
		while(itr1.hasNext()){
			t=itr1.next();				
			ListIterator<String> itr2inner=staat.listIterator();
			result.add(t);
			while(itr2inner.hasNext()){
				comparisions=comparisions+1;
				if(t.equals(itr2inner.next())){					
					itr2inner.remove();					
					break;
					
				}
				
			}
		}
		
		ListIterator<String> itr2copy=staat.listIterator();
		while(itr2copy.hasNext()){
			result.add(itr2copy.next());
		}
		
		tempstore=(LinkedList<String>) result.clone();
		
		if(result.isEmpty()){
			System.out.println("null");
			break;
		}
		result.clear();
	}		
	System.out.println("Comparisions:"+comparisions);
	return tempstore;
}

}
