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
		for(String temp:staatarray){
			System.out.println(temp+" :"+hmtaat.get(temp));
			
		}
	}
	public LinkedList<String> TAATand(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		LinkedList <String> staat=new LinkedList<String>();
		int comparisions=0;
		tempstore=hmtaat.get(staatarray[0]);
//		result=(LinkedList<String>) tempstore.clone();
		if(staatarray.length==1){
		result=(LinkedList<String>) tempstore.clone();
		}
		
		String t;
		for(int i=1;i<staatarray.length;i++){
			ListIterator<String> itr1=tempstore.listIterator();			
			staat=hmtaat.get(staatarray[i]);
			
			while(itr1.hasNext()){
				t=itr1.next();				
				ListIterator<String> itr2inner=staat.listIterator();
				while(itr2inner.hasNext()){
					comparisions=comparisions+1;
					if(t.equals(itr2inner.next())){
						result.add(t);
						System.out.println("staat :"+staat);
						itr2inner.remove();
						System.out.println("staat after :"+staat);
						break;
						
					}
					
				}
			}
			while (!tempstore.isEmpty()) {
		        tempstore.removeFirst();
		    }
			tempstore=(LinkedList<String>) result.clone();
			System.out.println("result"+result);
			System.out.println(tempstore);
			if(result.isEmpty()){
				System.out.println("null");
				break;
			}
			System.out.println("while loop");
		}		
		System.out.println("Comparisions:"+comparisions);
		return result;
	}
//	public LinkedList<String> DAATor(){
//		LinkedList<String> result=new LinkedList<String>();
//		LinkedList<String> tempstore=new LinkedList<String>();
//		int comparisions=0;
//		tempstore=hmdaat.get(sdaatarray[0]);
//		for(int i=1;i<sdaatarray.length;i++){
//			ListIterator<String> itr1=tempstore.listIterator();
//			ListIterator<String> itr2=hmdaat.get(sdaatarray[i]).listIterator();
//			String t;
//			String tt;
//
//			while(itr1.hasNext() && itr2.hasNext()){
//				t=itr1.next();
//				tt=itr2.next();				
//				int first=Integer.parseInt(t);
//				int second=Integer.parseInt(tt);
//				if(first==second){
//					result.add(t);
//					comparisions=comparisions+1;
//					System.out.println(t);
//					System.out.println(" here equal"+comparisions);
//					
//				}
//				else if(first>second){
//					//result.add(t);
//					while((first>second)&&(itr2.hasNext()))
//					{
//						comparisions=comparisions+1;
//						result.add(tt);
//						System.out.println("High first Integer number doc:"+second+" comparisions:"+comparisions);
//						tt=itr2.next();
//						second=Integer.parseInt(tt);						
//					}
//					if(first!=second){
//						result.add(t); 
//						itr2.previous();
//					}else{
//						result.add(t);
//					}
//					comparisions=comparisions+1;
//					System.out.println(comparisions);
//					
//					
//				}
//				else{
//					//result.add(tt);
//					while((first<second)&& (itr1.hasNext())){
//						comparisions=comparisions+1;
//						result.add(t);
//						System.out.println("less first integer:"+first);
//						t=itr1.next();
//						first=Integer.parseInt(t);						
//					}
//					
//						comparisions=comparisions+1;
//						System.out.println(comparisions);
//						if(first!=second){
//							result.add(tt);
//							itr1.previous();
//						}else{
//							result.add(tt);
//						}
//				}
//			}		
//			tempstore=result;
//			if(result.isEmpty()){
//				System.out.println("null");
//				break;
//			}
//
//		}
//		System.out.println("Comparisions:"+comparisions);
//		return result;	
//		}
//
}
