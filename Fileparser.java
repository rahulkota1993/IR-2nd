package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Fileparser {

	File file;
	FileReader filereader;
	BufferedReader br;
	
	HashMap<String, LinkedList<String>> hmindex;
	HashMap<String, Integer> hmtopterms;
	//removable terms
	FileWriter filewriter;//removable

	public Fileparser(String t) throws IOException {
		// TODO Auto-generated constructor stub
		file=new File(t);
		
		
		// hashmap for indexing
		hmindex = new HashMap<String, LinkedList<String>>();
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
			LinkedList<String> linkedlist = new LinkedList<String>();

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
				linkedlist.add(tokens2[0]);
			}
			hmindex.put(term, linkedlist);
			hmtopterms.put(term, sizeofpos);
			
			filewriter.write(term+": ");
			filewriter.write(hmindex.get(term).toString());
			//filewriter.write(hmtopterms.get(term).toString());
			filewriter.write("\n");	
			
		}		
		System.out.println("Execution successful :-)");
		filereader.close();
		filewriter.flush();
		filewriter.close();
	}
	
	HashMap<String, LinkedList<String>> gethashmapforindex(){
		return hmindex;
	}
	
	HashMap<String, Integer> gethashmapfortopkterms(){
		return hmtopterms;
	}
	
}
