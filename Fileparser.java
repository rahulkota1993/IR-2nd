package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Fileparser {

	File file;
	FileReader filereader;
	BufferedReader br;
	
	HashMap<String, LinkedList<Integer>> hmindex;
	HashMap<String, Integer> hmtopterms;
	//Hashmaps for 2nd index i.e. by doc frequency sorting order
	HashMap<String, LinkedList<Integer>> hmindextermfreq;
	
	//removable terms
	FileWriter filewriter;//removable

	public Fileparser(String t) throws IOException {
		// TODO Auto-generated constructor stub
		file=new File(t);
		
		
		// hashmap for indexing
		hmindex = new HashMap<String, LinkedList<Integer>>();
		//hashmap for indexing with termfreq
		hmindextermfreq=new HashMap<String, LinkedList<Integer>>();
		
		// hashmap for topkterms
		hmtopterms = new HashMap<String, Integer>();
		
		//removable
		filewriter=new FileWriter("assgn2.txt");//removable
	}

	void parsefileforindex() throws NumberFormatException, IOException {
		
		System.out.println("rahul");
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		String line=null;
		while ((line = br.readLine()) != null) {
			LinkedList<Integer> linkedlist = new LinkedList<Integer>();
			HashMap<Integer, Integer> hmtermfreq=new HashMap<Integer,Integer>();
			

			// formatting single line to obtain X Y Z from X\cY\mZ
			String[] tokens = line.split("\\\\");

			// Allocating values
			String term = tokens[0];

			String sizeofpostinglist = tokens[1];
			int sizeofpos = Integer.parseInt(sizeofpostinglist.substring(1,
					sizeofpostinglist.length()));

			String postinglist = tokens[2];
			// Formatting postings list i.e Z
			postinglist = postinglist.substring(1, postinglist.length());
			postinglist = postinglist.replaceAll("\\[|\\]", "");
			String[] tknpostinglist = postinglist.split(",");
			for (String val : tknpostinglist) {
				val = val.trim();// removing space which come after comma
				String[] tokens2 = val.split("/");// get the documents index
													// seperated from no. of
													// times they repeat
				linkedlist.add(Integer.parseInt(tokens2[0]));
				
				hmtermfreq.put(Integer.parseInt(tokens2[0]), Integer.parseInt(tokens2[1]));
			}
			
			
				valuecompareinteger vcr=new valuecompareinteger(hmtermfreq);
				TreeMap<Integer, Integer> tmtermfreq=new TreeMap<Integer, Integer>(vcr);
				tmtermfreq.putAll(hmtermfreq);
				//System.out.println(tmtermfreq);
				LinkedList<Integer> listtermfreq=new LinkedList<Integer>();
				Set<Map.Entry<Integer, Integer>> set = tmtermfreq.entrySet();

				for (Map.Entry<Integer, Integer> me : set) {
					
					listtermfreq.add(me.getKey());
				}
				hmindextermfreq.put(term, listtermfreq);

				
				
				
			
			
			Collections.sort(linkedlist);
			hmindex.put(term, linkedlist);
			hmtopterms.put(term, sizeofpos);
			
			filewriter.write(term+": ");
			filewriter.write(hmindextermfreq.get(term).toString());
			//filewriter.write(hmtopterms.get(term).toString());
			filewriter.write("\n");	
			
		}		
		System.out.println("Execution successful :-)");
		filereader.close();
		filewriter.flush();
		filewriter.close();
	}
	
	HashMap<String, LinkedList<Integer>> gethashmapforindex(){
		return hmindex;
	}
	HashMap<String, LinkedList<Integer>> gethashmapforindexwithtermfreq(){
		return hmindextermfreq;//to change
	}
	HashMap<String, Integer> gethashmapfortopkterms(){
		return hmtopterms;
	}
	
}
