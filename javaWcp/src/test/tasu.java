package test;

public class tasu{ //練習の為に使用
		static int j = 0;
		private int x=0;
		private int y=0;
		static String enpty = "-"; //nullの変わりにいれる
		static boolean win = false;

		public static int[] aaa(int num,int y) { //数字を入れる配列を作り計算したり testで作った　使わない
			int suchi[]= new int[2];
			suchi[0] = num+y;
			suchi[1] = num;
			return suchi;
	}
		public static String[][] banall = new String[8][8]; //配列を作り盤として使う
		public static  boolean setban(int x,int y,String stone) { //座標と置く石を決める
			boolean check = true;
			if (banall[x][y] == null) {//磐に何もなければ
			 banall[x][y] = stone; //受け取った石
			}
			else {
				System.out.println("そこには置けません");
				System.out.println("置けない(y,x)"+y+","+x);
				check = false; //置けない場合
				return check;
			}
			return check;
		}
		public static void print() { //盤の表示
			System.out.println("\n\t0\t1\t2\t3\t4\t5\t6\t7\n"); //上の数字プリント
			for(int y=0;y<banall.length;y++){ //盤の配列分ループ
	            System.out.print(y+"\t");
	            for(int x=0;x<banall[0].length;x++){
	              String b = banall[y][x];
	              if (b == null ) { //盤にnullがあるなら、"-"で表現
	            	  b = enpty; //上記で指定
	              }
	              System.out.print(b+"\t");
	            }
	            System.out.println("\n");
			}
		}
}