package test;
import java.util.Random; //ランダムに返すライブラリ
import java.util.Scanner; //入力をうけるライブラリ

public class test {
	static Random rnd = new Random(); //ランダム設定
	public static Scanner sc = new Scanner(System.in); //入力待ち
	public static void main(String[] args){ //メイン
		//宣言
	int[] black = new int[5];
	int green = 0;
	int[][] ban = new int[8][8];
	String enpty = "-";
	String kuro = "●";
	String shiro = "◯";
	boolean player = true;
	boolean check =true;

	while (true) { //ループ
	if ( player == true) { //人
		while(true) { //人ループ
	System.out.print("数字を入れてください(縦横) >");
	String suzi = sc.next(); //入力を取得
	char c0 = suzi.charAt(0),c1 = suzi.charAt(1); //1文字ずつ取り出し
	if((suzi.length() != 2) && (Character.isDigit(c0)!=true) && (Character.isDigit(c1)!=true)) {
		System.out.println("入力に問題があります。もう一度");
		Integer.parseInt(suzi);
		break;
	}

		int i0 = Character.getNumericValue(c0), i1 = Character.getNumericValue(c1); //int型に変更
		check = tasu.setban(i0,i1,kuro); //入力された座標に●を代入
		if (check == false) {
			System.out.println("既に石が置かれています。");
			break;
		}
//		tasu.print(); //盤の表示
		System.out.println("入力した数字は"+suzi+"で,置かれた石は"+kuro+"です。");
		player = false; //couに交代
		check = true;
		break;
		}
	}
	else { //雑魚cpu
		while(true) { //cpuループ
		int x = rnd.nextInt(8); //指定内の数字からランダムに返す
		int y = rnd.nextInt(8);
		boolean stop = false;
		stop = checked.cputansaku();
		if(stop != true) { //3つ、4つ置かれていたら止める
		check = tasu.setban(x, y, shiro);
		}
		if (check == false) {
			break;
		}
		System.out.println("cpuは"+x+y+"に◯を置きました");
		tasu.print(); //盤の表示
		player = true; //人に交代
		check = true;
		break;
	}
	}
	 boolean win = checked.chekedwin(player); //5つ並んでいるかの判定
	 if(win == true) {
		 break;
	 }
	}
	}
}
