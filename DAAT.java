package assignment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DAAT {
	String sdaat;
	HashMap<String, LinkedList<String>> hmdaat;
	String[] sdaatarray;



	public DAAT(String s,HashMap<String, LinkedList<String>> sl){
		sdaat=s;
		hmdaat=sl;

		sdaatarray=sdaat.split(" ");
		stringarraycomparator scp=new stringarraycomparator(hmdaat);
		Arrays.sort(sdaatarray, scp);
		for(String temp:sdaatarray){
			System.out.println(temp+" :"+hmdaat.get(temp));

		}
	}

	public LinkedList<String> DAATand(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		tempstore=hmdaat.get(sdaatarray[0]);
		for(int i=1;i<sdaatarray.length;i++){
			ListIterator<String> itr1=tempstore.listIterator();
			ListIterator<String> itr2=hmdaat.get(sdaatarray[i]).listIterator();
			String t;
			String tt;

			while(itr1.hasNext() && itr2.hasNext()){
				t=itr1.next();
				tt=itr2.next();
				
				int first=Integer.parseInt(t);
				int second=Integer.parseInt(tt);
				if(first==second){
					result.add(t);
					comparisions=comparisions+1;
					System.out.println(t);
					System.out.println(" here equal"+comparisions);

				}
				else if(first>second){
					while((first>second)&&(itr2.hasNext())){
						comparisions=comparisions+1;
						System.out.println("High first Integer number doc:"+second+" comparisions:"+comparisions);
						tt=itr2.next();
						second=Integer.parseInt(tt);						
					}
					comparisions=comparisions+1;
					System.out.println(comparisions);
					if(first==second){
						result.add(t);
					}
					//itr2.previous();
				
						
					

				}
				else{
					while((first<second)&& (itr1.hasNext())){
						comparisions=comparisions+1;
						System.out.println("less first integer:"+first);
						t=itr1.next();
						first=Integer.parseInt(t);						
					}
					
						comparisions=comparisions+1;
						System.out.println(comparisions);
						if(first==second){
							result.add(t);
						}
						//itr1.previous();
					//System.out.println("itr1 comparisions :"+t+" comparisions: "+comparisions);
					//t=itr1.next();
				}

			}
			
			
			tempstore=result;
			if(result.isEmpty()){
				System.out.println("null");
				break;
			}

		}
		System.out.println("Comparisions:"+comparisions);
		return result;
	}
	public LinkedList<String> DAATor(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		tempstore=hmdaat.get(sdaatarray[0]);
		for(int i=1;i<sdaatarray.length;i++){
			Iterator<String> itr1=tempstore.iterator();
			Iterator<String> itr2=hmdaat.get(sdaatarray[i]).iterator();
			String t=itr1.next();
			String tt=itr2.next();
			while(itr1.hasNext() && itr2.hasNext()){
				comparisions=comparisions+1;
				int ab=Integer.parseInt(t);
				int b=Integer.parseInt(tt);
				if(ab==b){
					result.add(t);
					t=itr1.next();
					tt=itr2.next();
					System.out.println(t);
					System.out.println(" here equal"+comparisions);

				}
				else if(ab>b){
					System.out.println("itr2: "+tt+" comparisions:"+comparisions);
					result.add(tt);
					tt=itr2.next();
					

				}else{
					System.out.println("itr1 comparisions :"+t+" comparisions: "+comparisions);
					result.add(t);
					t=itr1.next();
				}
				if((!itr1.hasNext()) || (!itr2.hasNext())){
					if(t.equals(tt)){
						result.add(t);
					}	
					comparisions=comparisions+1;
				}
			}
			tempstore=result;
			if(result.isEmpty()){
				System.out.println("null");
				break;
			}
		}
			
		System.out.println("comparisions or:"+comparisions);
	return result;
	}
	
	
	
//	public LinkedList<String> DAATor(){
//		LinkedList<String> result=new LinkedList<String>();
//		LinkedList<String> tempstore=new LinkedList<String>();
//		tempstore=hmdaat.get(sdaatarray[0]);
//		for(int i=1;i<sdaatarray.length;i++){
//
//			Iterator<String> itr1=tempstore.iterator();
//			Iterator<String> itr2=hmdaat.get(sdaatarray[i]).iterator();
//			String t=itr1.next();
//			String tt=itr2.next();
//			//System.out.println("lets see");
//			while(itr1.hasNext() && itr2.hasNext()){
//
//				int ab=Integer.parseInt(t);
//				int b=Integer.parseInt(tt);
//				if(ab==b){
//					result.add(t);
//					System.out.println("lets see");
//				}
//				else{
//					result.add(t);
//					result.add(tt);		
//					System.out.println("lets see");
//				}
//				t=itr1.next();
//			}
//			System.out.println("rahul");
//			if(t.equals(tt)){
//				result.add(t);
//
//			}
//			else{
//				result.add(t);
//				result.add(tt);
//			}
//			System.out.println("here again");
//			if(itr1.hasNext()){
//
//				while(itr1.hasNext()){
//					result.add(itr1.next());
//				}
//			}
//			else if(itr2.hasNext()){
//
//				while(itr2.hasNext()){
//					//	System.out.println(itr2.next());
//					result.add(itr2.next());
//				}			
//			}
//			System.out.println(result);
//			tempstore=result;
//		}
//		System.out.println(result);
//		return result;
//	}
}

