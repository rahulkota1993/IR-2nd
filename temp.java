package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class temp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// File file=new
		// File("C:/Users/Rahul/Desktop/Information Retrieval/Programming assignment/term.idx");
		//
		// try {
		// FileReader filereader=new FileReader(file);
		//
		// BufferedReader br=new BufferedReader(filereader);
		// String temp;
		// while((temp=br.readLine()) != null){
		// System.out.println(temp);
		// }
		//
		// System.out.println("closed");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// String temp="m[0010013/1]";
		// temp=temp.substring(1, temp.length());
		// temp=temp.replaceAll("\\[|\\]","");
		// String[] tokens=temp.split(",");
		// for(String val:tokens){
		// val=val.trim();//removing space which come after comma
		// String[] tokens2=val.split("/");
		// System.out.println(tokens2[0]);
		// }

		// To check whether the input is number or not
		// String regex = "[0-9]+";
		// String data = "23343453";
		// System.out.println(data.matches(regex));

		// String[] abc={"rahul","sunny"};
		// String[] lis={"0923","0981"};
		// String[] li={"0234","0231"};
		// HashMap<String, LinkedList<String>> hm=new HashMap<String,
		// LinkedList<String>>();
		// for(int i=0;i<2;i++){
		// LinkedList<String> a=new LinkedList<String>();
		// a.add(lis[i]);
		// a.add(li[i]);
		//
		// hm.put(abc[i], a);
		// }
		// System.out.println(hm.get("rahul"));
		// System.out.println(hm.get("sunny"));

		// System.out.println(args[0] + " 2. "+args[1]+" 3." +args[2]);



		Fileparser fileparser=new Fileparser("term.idx");

		//parsing file for index
		fileparser.parsefileforindex();

		//Loading Hashmaps for index and topkterms
		HashMap<String, LinkedList<Integer>> gethmindex=new HashMap<String, LinkedList<Integer>>();
		HashMap<String, LinkedList<Integer>> gethmindextermfreq=new HashMap<String, LinkedList<Integer>>();
		gethmindex=fileparser.gethashmapforindex();
		gethmindextermfreq=fileparser.gethashmapforindexwithtermfreq();
		LinkedList<Integer> result=new LinkedList<Integer>();
		LinkedList<Integer> tempstore=new LinkedList<Integer>();

		//String a="-nation -member zambia z";
		
		String a="!DOCTYPE 19000228";
		String[] strings=a.split(" ");
		stringarraycomparator scp=new stringarraycomparator(gethmindex);
		Arrays.sort(strings, scp);
		for(String temp:strings){
			System.out.println(temp+" :"+gethmindex.get(temp));
			
		}
		tempstore=gethmindex.get(strings[0]);
		
		for(int i=1;i<strings.length;i++){
			Iterator<Integer> itr1=tempstore.iterator();
			Iterator<Integer> itr2=gethmindex.get(strings[i]).iterator();
			
			while(itr1.hasNext() && itr2.hasNext()){
				int ab=itr1.next();
				int b=itr2.next();
				if(ab==b){
					result.add(ab);
					
				}
				else if(ab<b){
					itr1.next();
				}else{
					itr2.next();
				}
			}
			tempstore=result;
	
		}
		System.out.println(result);
		
		
		//System.out.println(gethmindex.get(strings[1]).size());


	}

}
