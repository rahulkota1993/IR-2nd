package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class data {

	public static void main(String args[]){
		try{
			//Loading file reader
			File file=new File(args[0]);
			FileReader filereader=new FileReader(file);
			BufferedReader br=new BufferedReader(filereader);
			String line=null;
			FileWriter filewriter=new FileWriter("assgn2.txt");
			
			//Creating hashmap for index
			HashMap<String, LinkedList<String>> hmindex=new HashMap<String, LinkedList<String>>();

			//Creating hashmaps for finding top k terms
			HashMap<String, Integer> hmtopterms=new HashMap<String, Integer>();
			valuecompare vc=new valuecompare(hmtopterms);
			TreeMap<String, Integer> tmtopterms=new TreeMap<String, Integer>(vc);
			
			//top terms for k values class
			String topkpath="C:/Users/Rahul/Desktop/Information Retrieval/json files/topkterms.txt";
			topterms topk=new topterms(5,topkpath);

			//Reading from file reader
			while((line=br.readLine())!=null)
			{
				//			String line=br.readLine();
				//System.out.println(line);
				LinkedList<String> linkedlist=new LinkedList<String>();

				//formatting single line to obtain X Y Z from X\cY\mZ
				String[] tokens=line.split("\\\\");

				//Allocating values
				String term=tokens[0];
				String sizeofpostinglist=tokens[1];
				int sizeofpos=Integer.parseInt(sizeofpostinglist.substring(1, sizeofpostinglist.length()));
				String postinglist=tokens[2];
				//System.out.println(term+" "+sizeofpostinglist+ " integer "+sizeofpos+" "+postinglist);

				//Formatting postings list i.e Z
				postinglist=postinglist.substring(1,postinglist.length());
				postinglist=postinglist.replaceAll("\\[|\\]","");
				String[] tknpostinglist=postinglist.split(",");
				for(String val:tknpostinglist){

					val=val.trim();//removing space which come after comma
					String[] tokens2=val.split("/");//get the documents index seperated from no. of times they repeat

					linkedlist.add(tokens2[0]);

				}
				hmindex.put(term, linkedlist);
				hmtopterms.put(term,sizeofpos);
				filewriter.write(term+": ");
				filewriter.write(hmindex.get(term).toString());
				//filewriter.write(hmtopterms.get(term).toString());
				filewriter.write("\n");
			}

			tmtopterms.putAll(hmtopterms);
			topk.getTopK(tmtopterms);
			System.out.println("Execution successful :-)");
			filereader.close();
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
