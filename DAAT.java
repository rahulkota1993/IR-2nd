 package assignment2;

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

	public DAAT(String s,HashMap<String, LinkedList<String>> sl){
		sdaat=s;
		hmdaat=sl;
		sdaatarray=sdaat.split(" ");
		stringarraycomparator scp=new stringarraycomparator(hmdaat);
		Arrays.sort(sdaatarray, scp);
		for(String temp:sdaatarray){
			System.out.println(temp+" :"+hmdaat.get(temp));
			System.out.println("size :"+hmdaat.get(temp).size());

		}
	}

	public LinkedList<String> DAATand(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		tempstore=(LinkedList<String>) hmdaat.get(sdaatarray[0]).clone();
		if(sdaatarray.length==1){
			result=(LinkedList<String>) tempstore.clone();
		}
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
					//System.out.println(t);
					//System.out.println(" here equal"+comparisions);
				}
				else if(first>second){
					while((first>second)&&(itr2.hasNext()))
					{
						comparisions=comparisions+1;
						//System.out.println("High first Integer number doc:"+second+" comparisions:"+comparisions);
						tt=itr2.next();
						second=Integer.parseInt(tt);

					}
					comparisions=comparisions+1;
					//System.out.println(comparisions);
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
						//System.out.println("less first integer:"+first);
						t=itr1.next();
						first=Integer.parseInt(t);						
					}					
					comparisions=comparisions+1;
					//System.out.println(comparisions);
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
				System.out.println("null");
				break;
			}
			result.clear();

		}
		System.out.println("Comparisions:"+comparisions);
		return tempstore;
	}
	public LinkedList<String> DAATor(){
		LinkedList<String> result=new LinkedList<String>();
		LinkedList<String> tempstore=new LinkedList<String>();
		int comparisions=0;
		tempstore=(LinkedList<String>) hmdaat.get(sdaatarray[0]).clone();
		if(sdaatarray.length==1){
			result=(LinkedList<String>) tempstore.clone();
		}
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
					//result.add(tt);
					while((first<second)&& (itr1.hasNext())){
						comparisions=comparisions+1;
						result.add(t);
						//System.out.println("less first integer:"+first);
						t=itr1.next();
						first=Integer.parseInt(t);						
					}

					comparisions=comparisions+1;
					//System.out.println(comparisions);
					//						if(first!=second){
					//							result.add(tt);
					//							itr1.previous();
					//						}else{
					//							result.add(tt);
					//						}
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
		return tempstore;	
	}
}

