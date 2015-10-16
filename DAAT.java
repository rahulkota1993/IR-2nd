 package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DAAT {
	String sdaat;
	HashMap<String, LinkedList<String>> hmdaat;
	String[] sdaatarray;
	int compand=0;
	int compor=0;

	public DAAT(String s,HashMap<String, LinkedList<String>> sl){
		sdaat=s;
		hmdaat=sl;
		sdaatarray=sdaat.split(" ");
//		stringarraycomparator scp=new stringarraycomparator(hmdaat);
// 		Arrays.sort(sdaatarray, scp);

	}

	public LinkedList<String> DAATand(){
		
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		for(String test:sdaatarray){
			if(hmdaat.get(test)==null){
				tempstore.add("terms not found");
				compand=comparisions;
				return tempstore;
			}
		}
		stringarraycomparator scp=new stringarraycomparator(hmdaat);
		Arrays.sort(sdaatarray, scp);
		
		
		tempstore=(LinkedList<String>) hmdaat.get(sdaatarray[0]).clone();

		for(int i=1;i<sdaatarray.length;i++){
			ListIterator<String> itr1=tempstore.listIterator();
			LinkedList<String> lister=new LinkedList<String>();
			lister=(LinkedList<String>) hmdaat.get(sdaatarray[i]).clone();
			ListIterator<String> itr2=lister.listIterator();
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
					
				}
				else if(first>second){
					while((first>second)&&(itr2.hasNext()))
					{
						comparisions=comparisions+1;
						
						tt=itr2.next();
						second=Integer.parseInt(tt);

					}
					comparisions=comparisions+1;
					
					if(first==second)
					{
						result.add(t);
						
					}else{
						itr2.previous();
					}
				}
				else{
					while((first<second)&& (itr1.hasNext())){
						comparisions=comparisions+1;
						
						t=itr1.next();
						first=Integer.parseInt(t);						
					}					
					comparisions=comparisions+1;
					
					if(first==second){						
						result.add(t);
											}			
					else{
						itr1.previous();
					}
				}
			}			
			
			tempstore=(LinkedList<String>) result.clone();
			
			if(result.isEmpty()){
				tempstore.clear();
				tempstore.add("terms not found");
				compand=comparisions;
				return tempstore;
			}
			result.clear();

		}
		System.out.println("Comparisions:"+comparisions);
		compand=comparisions;
		return tempstore;
	}
	public LinkedList<String> DAATor(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		

		ArrayList<String> al=new ArrayList<String>();
		for(String test:sdaatarray){
			if(hmdaat.containsKey(test)){
				al.add(test);
			}
		}
		if(al.size()==0){
			tempstore.add("terms not found");
			compor=comparisions;
			return tempstore;
		}
		String[] daatorarray=new String[al.size()];
		daatorarray=al.toArray(daatorarray);
		System.out.println("daatorarraylength :"+daatorarray.length);
		for(int i=0;i<daatorarray.length;i++){
			System.out.println("array elements: "+daatorarray[i]);
		}
		
		
		stringarraycomparator scpor=new stringarraycomparator(hmdaat);
		Arrays.sort(daatorarray, scpor);
		
		tempstore=(LinkedList<String>) hmdaat.get(daatorarray[0]).clone();
		for(int i=1;i<daatorarray.length;i++){
			ListIterator<String> itr1=tempstore.listIterator();
			ListIterator<String> itr2=hmdaat.get(daatorarray[i]).listIterator();
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
					//System.out.println(t);
					//System.out.println(" here equal"+comparisions);

				}
				else if(first>second){
									
					while((first>second)&&(itr2.hasNext()))
					{
						comparisions=comparisions+1;
						result.add(tt);
					//	System.out.println("High first Integer number doc:"+second+" comparisions:"+comparisions);
						tt=itr2.next();
						second=Integer.parseInt(tt);						
					}
					

					if(first>second){
						result.add(tt);
						comparisions++;
					}
					comparisions++;
					if(first!=second){
						result.add(t);
						if(first<second){
						itr2.previous();
						}
					}else{
						result.add(t);
					}

				}
				else{
					
					while((first<second)&& (itr1.hasNext())){
						comparisions=comparisions+1;
						result.add(t);
						
						t=itr1.next();
						first=Integer.parseInt(t);						
					}

					comparisions=comparisions+1;
					
					if(second>first){
						comparisions++;
						result.add(t);
					}
					comparisions++;
					if(first!=second){
						result.add(tt);
						if(first>second){
							itr1.previous();
							}
						
					}else{
						result.add(tt);
					}
				}
			}		

						while((itr1.hasNext())&&(!itr2.hasNext())){
							result.add(itr1.next());
							
						}
						while((itr2.hasNext())&&(!itr1.hasNext())){
							result.add(itr2.next());
						}
			tempstore=(LinkedList<String>) result.clone();
			result.clear();
			//System.out.println("tempstore :"+tempstore);


		}
		System.out.println("Comparisions:"+comparisions);
		compor=comparisions;
		return tempstore;	
	}
	public int comparisonsand(){
		
		return compand;
	}
	public int comparisionsor(){
		return compor;
	}
}

