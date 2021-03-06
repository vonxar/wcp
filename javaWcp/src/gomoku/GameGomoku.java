package gomoku;

import java.util.Scanner;

public class GameGomoku{
	public static Scanner sc = new Scanner(System.in); //入力待ち
	  public static void main(String[] args){
	    Field field = new Field(8,8);
	    field.prepare();
	    field.feature();

	    System.out.println("---------------------------------------------------");

	  //メインループ
	    boolean check = true; //入力した文字の長さ判定用
	  		while (true) {
	  			boolean playerCan = true;
				boolean enemyCan = true;


	  		//プレイヤーの処理----------
	  			field.feature();
	  			if (check == true ) {
				System.out.println("あなたの番です。 横縦の順番で数字を入力してください");
	  			} else {
	  				System.out.println("入力が正しくありません");
	  			}
				while (true) {
					String point = sc.next(); //入力を取得
					if (point.length() != 2) {
						check = false;
						break;
					}
					else {
						check = true;
						char c0 = point.charAt(0),c1 = point.charAt(1); //1文字ずつ取り出し
						if (Character.isDigit(c0) != true && Character.isDigit(c1) != true) {
							System.out.println("入力が正しくありません");
						}
						if  (point.length() != 2 || (c0<'0'||'7'<c0) || (c1<'0'||'7'<c1)){
							System.out.println("入力が正しくありません");
						}
						else {
							int x = Character.getNumericValue(c0); //char型からint型に変換
							int y = Character.getNumericValue(c1); //char型からint型に変換
							if (playerCan == true) {
								field.putKoma(x,y,"●"); //座標の指定
								System.out.println("---------------------------------------------------");
								System.out.println("あなたは"+c0+","+c1+"に石を置きました");
								break;
			//					Field set = null;
							}
							else {
								System.out.println("その場所には石を置くことができません");
							}
						}
					}
				}
				//ゲーム終了判定
				Judge.winJudge();
				if (playerCan == false && enemyCan == false) {
				}
					break;
			}
	  	//対戦結果表示
			field.result();
	  }
}