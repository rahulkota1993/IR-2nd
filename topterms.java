package assignment2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class topterms {
	int num;
	FileWriter fw;

	public topterms(int k, String s) {
		num = k;
		try {
			fw = new FileWriter(
					"topktermslog.log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTopK(TreeMap<String, Integer> t) throws IOException {
		Set<Map.Entry<String, Integer>> set = t.entrySet();
		int i = 0;
		fw.write("FUNCTION: getTopK "+num+"\n"+"Result: ");
		for (Map.Entry<String, Integer> me : set) {
			//System.out.println(me.getKey() + " :" + me.getValue());
			
			fw.write(me.getKey());
			i++;
			if (i == num) {
				fw.flush();
				fw.close();
				break;
			}else{
				fw.write(", ");
			}
		}
	}
}
