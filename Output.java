package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class Output {
	TreeMap<String, Integer> treemap;
	HashMap<String, LinkedList<String>> outputgethmindex;
	HashMap<String, LinkedList<String>> outputgethmindextermfreq;
	FileWriter fw;
	String frs;
	int top;
	
	
	public Output(String fwr,String topknum,String frd,TreeMap<String, Integer> tm,HashMap<String, LinkedList<String>> gethmindex,HashMap<String, LinkedList<String>> gethmindextermfreq){
		treemap=tm;
		
		treemap=tm;
		outputgethmindex=gethmindex;
		outputgethmindextermfreq=gethmindextermfreq;
		top=Integer.parseInt(topknum);
		frs=frd;
		try {
			 fw = new FileWriter(fwr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getTopK() throws IOException {
		Set<Map.Entry<String, Integer>> set = treemap.entrySet();
		int i = 0;
		fw.write("FUNCTION: getTopK "+top+"\n"+"Result: ");
		for (Map.Entry<String, Integer> me : set) {						
			fw.write(me.getKey());
			i++;
			if (i == top) {
//				fw.flush();
//				fw.close();
				break;
			}else{
				fw.write(", ");
			}
		}
		fw.write("\n");
	}

	public void executeoutput() throws IOException{
		System.out.println("rahul");
		FileReader filereader = new FileReader(frs);
		BufferedReader br = new BufferedReader(filereader);
		String line=null;
		while ((line = br.readLine()) != null) {
		System.out.println("File :"+line);
		postingslist(line);
		DAATprint(line);
		fw.write("\n");
		
		 }
		fw.flush();
		fw.close();
		}
	public void postingslist(String termline) throws IOException{
		String local=termline;
		String[] tokens=local.split(" ");
		for(String s:tokens){
			fw.write("FUNCTION: getPostings "+s+"\n"+"Ordered by doc IDs: ");
			Iterator<String> itr=outputgethmindex.get(s).iterator();
			while(itr.hasNext()){
				fw.write(itr.next());
				if(itr.hasNext()){
					fw.write(", ");
				}
			}
			fw.write("\n");
			fw.write("Ordered by TF: ");
			Iterator<String> itr2=outputgethmindextermfreq.get(s).iterator();
			while(itr2.hasNext()){
				fw.write(itr2.next());
				if(itr2.hasNext()){
					fw.write(", ");
				}
			}
			fw.write("\n");
			
			
			System.out.println(s);
		}
		
	}

	public void DAATprint(String termline) throws IOException{
		fw.write("FUNCTION: docAtATimeQueryAnd ");
		String local=termline;
		String[] tokens=local.split(" ");
		for(int i=0;i<tokens.length;i++){
			fw.write(tokens[i]);
			if(i<tokens.length-1){
				fw.write(", ");
			}
			
		}
		DAAT daatlocal=new DAAT(local,outputgethmindex);
		LinkedList<String> lst= (LinkedList<String>) daatlocal.DAATand().clone();
		//System.out.println("AND RESULT :"+lst);
		//System.out.println("size :"+lst.size());
		LinkedList<String> lstor=(LinkedList<String>) daatlocal.DAATor().clone();
		System.out.println("OR RESULT :"+lstor);
		System.out.println("size :"+lstor.size());
		TAAT taatlocal=new TAAT(local,outputgethmindextermfreq);
		LinkedList<String> lst2=(LinkedList<String>) taatlocal.TAATor().clone();
		System.out.println("term or RESULT: "+lst2);
		System.out.println(lst2.size());
	}
	
	public void TAATprint(String termline) throws IOException{
		fw.write("FUNCTION: termAtATimeQueryAnd ");
		String local=termline;
		String[] tokens=local.split(" ");
		for(int i=0;i<tokens.length;i++){
			fw.write(tokens[i]);
			if(i<tokens.length-1){
				fw.write(", ");
			}
		}
	}
}

