package beginner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Case006 {

	/*
	 * コマンドライン引数の第１をコマンド名として、
	 * そのコマンドに与える引数を第２引数から設定する
	 */
	public static void main(String[] args) {
		if(args.length > 0) {
			String command = args[0];
			switch(command) {
				case "tac":
					if(args.length >= 1) {
						File file = new File(args[1]);
						try(BufferedReader in = new BufferedReader(new FileReader(file))){
							String str;
							ArrayList<String> sarray = new ArrayList<String>();
							while((str = in.readLine()) != null) {
								String[] strs = str.split("[ \\t]");
								for(int i=0; i<strs.length; i++) {
									sarray.add(strs[i]);
								}
								sarray.add("\n");
							}
							Collections.reverse(sarray);
							sarray.forEach(n->System.out.print(n + " "));
						} catch (FileNotFoundException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						} catch (IOException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					break;
				case "wc":
					break;
				default:
					break;
			}
		}
	}

}
