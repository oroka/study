package beginner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Case005 {

	public static void main(String[] args) {
		File file = new File(args[0].toString());
		Map<String, Integer> smap = new HashMap<String, Integer>();
		try(BufferedReader in = new BufferedReader(new FileReader(file))) {
			String str;
			while((str = in.readLine()) != null) {
				String[] text = str.split("[ \\t]");
				for(String s : text) {
					s = s.toLowerCase();
					s = s.replaceAll("[\"\',.;:]+", "");
					if(smap.get(s)!=null) {
						smap.put(s, smap.get(s)+1);
					}else {
						smap.put(s, 1);
					}
				}
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		smap.forEach((s,v)->System.out.println(s + " " + v + "回"));
	}

}
