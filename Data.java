package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class data {

	public static void main(String args[]){
		try{
			
			Fileparser fileparser=new Fileparser(args[0]);
			
			//parsing file for index
			fileparser.parsefileforindex();
			
			//Loading Hashmaps for index and topkterms
			HashMap<String, LinkedList<Integer>> gethmindex=new HashMap<String, LinkedList<Integer>>();
			HashMap<String, LinkedList<Integer>> gethmindextermfreq=new HashMap<String, LinkedList<Integer>>();
			gethmindex=fileparser.gethashmapforindex();
			gethmindextermfreq=fileparser.gethashmapforindexwithtermfreq();
			
			HashMap<String, Integer> gethmtopterms=new HashMap<String, Integer>();
			
			//Creating treemap for gethmtopterms hashmap
			gethmtopterms=fileparser.gethashmapfortopkterms();
			valuecompare vc=new valuecompare(gethmtopterms);
			TreeMap<String, Integer> tmtopterms=new TreeMap<String, Integer>(vc);					
			System.out.println(gethmtopterms.size());
			tmtopterms.putAll(gethmtopterms);
			
			//top terms for k values class
			String topkpath="C:/Users/Rahul/Desktop/Information Retrieval/json files/topkterms.txt";
			topterms topk=new topterms(5,topkpath);
			topk.getTopK(tmtopterms);
			System.out.println("Execution successful :-)");
			
			String test="zone";
			System.out.println(gethmindex.get(test)+"\n");
			System.out.println(gethmindextermfreq.get(test));
			
				}catch(Exception e){
			e.printStackTrace();
			System.out.println("here");
		}

	}
}
