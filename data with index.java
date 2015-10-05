package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class data {

	public static void main(String args[]){
		try{
			//Loading file reader
			File file=new File("C:/Users/Rahul/Desktop/Information Retrieval/Programming assignment/term.idx");
			FileReader filereader=new FileReader(file);
			BufferedReader br=new BufferedReader(filereader);
			String line=null;
			FileWriter filewriter=new FileWriter("C:/Users/Rahul/Desktop/Information Retrieval/json files/assgn2.txt");
			
			//Creating hashmap for index
			HashMap<String, LinkedList<String>> hm=new HashMap<String, LinkedList<String>>();

			//Reading from file reader
			//			String temp=br.readLine();
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
					
					//System.out.println("tokens2 :"+tokens2[0]);
//					filewriter.write(tokens2[0]);
//					filewriter.write(" ");
					
				}
				hm.put(term, linkedlist);
				filewriter.write(term+": ");
				filewriter.write(hm.get(term).toString());
				filewriter.write("\n");
				filewriter.write("\n");
			}
			System.out.println(hm);
			filereader.close();
			filewriter.flush();
			filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
