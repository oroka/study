package beginner;

import java.io.File;
import java.util.stream.Stream;

public class Case003 {
	public static void main(String[] args) {
		File dir = new File(".");
		getFiles(dir);
	}

	public static void getFiles(File file){
		if(file.isFile()) System.out.println(file.toString());
		else if(file.isDirectory()){
			Stream.of(file.listFiles()).forEach(n->getFiles(n));
		}
	}
}
