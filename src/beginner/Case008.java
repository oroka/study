package beginner;

public class Case008 {

	/*
	 * 迷路の作成
	 */
	public static void main(String[] args) {
		int x = 21;
		int y = 41;
		String[][] map = new String[y][x];
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				map[i][j] = " ";
				if(i==0 || i==y-1 || j==0 || j==x-1) {
					map[i][j] = "X";
				}
				if(i>0 && i<y-1 && i%2==0) {
					if(j>0 && j<x-1 && j%2==0) {
						map[i][j] = "X";
					}
				}
			}
		}

		map[(int)(Math.random()*(y-1))][0] = "S";
		map[(int)(Math.random()*(y-1))][x-1] = "G";

		for(int i=2; i<y-2; i+=2) {
			for(int j=2; j<x-2; j+=2) {
				if(map[i][j] == "X") {
					int rand = 0;
					if(j==2) rand = (int)(Math.random()*4)+1;
					else rand = (int)(Math.random()*3)+1;
					switch(rand) {
					case 1:
						map[i-1][j] = "X";
						break;
					case 2:
						map[i+1][j] = "X";
						break;
					case 3:
						map[i][j+1] = "X";
						break;
					case 4:
						map[i][j-1] = "X";
						break;

					}
				}
			}
		}

		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
