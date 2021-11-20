package beginner;

public class Case001 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		for(int i=0; i<args.length; i++) {
			if(args[i].toString().equals("KSUAP")) System.out.println("渡された文字列は\"KSUAP\"です。");
			else System.out.println("渡された文字列は\"KSUAP\"ではなく" + args[i] + "です。");
		}
	}

}
