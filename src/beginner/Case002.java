package beginner;

import java.util.ArrayList;
import java.util.Collections;

public class Case002 {

	public static void main(String[] args) {
		ArrayList<Integer> rns = new ArrayList<Integer>();
		for(int i=0; i<100; i++)
			rns.add(Integer.valueOf((int)(1000*Math.random())));
		Integer sum = rns.stream().reduce(0, (a,b)->(a+b));
		System.out.println("合計：" + sum + ", 最大値：" + Collections.max(rns) + ",最小値：" + Collections.min(rns) + ",平均値：" + sum/100);
		for(int i=0; i<100; i++) {
			if(i%10==0) {
				System.out.println();
			}
			System.out.print(rns.get(i) + " ");
		}
	}

}
