package beginner;

import java.util.Stack;

public class Case007 {

	/*
	 * 逆ポーランド記法の計算
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		int val1, val2, result=0;
		String str = "";
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
			str += args[i];
			if(i!=args.length-1) str += " ";
			switch(args[i]) {
				case "+":
					val2 = stack.pop();
					val1 = stack.pop();
					result = val1 + val2;
					stack.push(result);
					break;
				case "-":
					val2 = stack.pop();
					val1 = stack.pop();
					result = val1 - val2;
					stack.push(result);
					break;
				case "'*'":
					val2 = stack.pop();
					val1 = stack.pop();
					result = val1 * val2;
					stack.push(result);
					break;
				case "/":
					val2 = stack.pop();
					val1 = stack.pop();
					result = val1 / val2;
					stack.push(result);
					break;
				default:
					stack.push(Integer.valueOf(args[i]));
					break;
			}
		}
		System.out.println(result + "(" + str + ")");
	}

}
