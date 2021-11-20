package beginner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * wcコマンドの作成
 */
public class Case004 {

	public static void main(String[] args) {
		int totalChar=0, totalWord=0, totalLine=0;
		System.out.println("Char Word Line");
		for(String str : args){
			int Char=0, Word=0, Line=0;
			File file = new File(str);
			try(BufferedReader in = new BufferedReader(new FileReader(file))){
				String line;
				while((line = in.readLine()) != null) {
					String[] chars = line.split("[ \t]");
					for(int i=0; i<chars.length; i++) {
						Char+=chars[i].length();
					}
					Word += chars.length;
					Line+=1;
				}
				System.out.printf("%4d %4d %4d %s\n", Char, Word, Line, str);
				totalChar += Char;
				totalWord += Word;
				totalLine += Line;
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			};
		}
		System.out.printf("%4d %4d %4d %s\n", totalChar, totalWord, totalLine, "Total");

	}

}
