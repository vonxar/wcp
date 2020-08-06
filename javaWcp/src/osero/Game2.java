package osero;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Game2 {
	public static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {

		//盤の生成
		Board board = new Board();

		//AIの生成
		System.out.println("AIの強さを選択してください　0：よわい　1：つよい");
		int AI = -1;
		while (true) {
			String temp = sc.next();
			if (!temp.equals("0") && !temp.equals("1")) {
				System.out.println("ただしい強さを入力してください");
			}
			else {
				AI = Integer.parseInt(temp);
				System.out.println((AI==0?"よわい":"つよい")+"AIが生成されました");
				System.out.println();
				break;
			}
		}

		System.out.println("---------------------------------------------------");

		//メインループ
		while (true) {

			boolean playerCanSet = true;
			boolean enemyCanSet = true;


			//プレイヤーの処理----------
			board.print();
			System.out.println("あなたの番です");
			board.findSetPoints("⚫️");
			if (board.blackList.size() != 0) {
				Point set = null;
				while (true) {
					String temp = sc.next();
					char c0 = temp.charAt(0), c1 = temp.charAt(1);
					if ((c1<'a'&&'h'<c1)) {
						System.out.println("入力が正しくありません");
					}
					if  (temp.length()!=2 || (c0<'1'||'8'<c0) || (c1<'a'||'h'<c1)){
						System.out.println("入力が正しくありません");
					}
					else {
						int y = temp.charAt(0) - '0';
						int x = temp.charAt(1) - 'a' + 1;
						if (board.containSetPoints(y, x) == true) {
							set = new Point(y, x);
							board.revStone("⚫️", y, x);
							System.out.println("---------------------------------------------------");
							System.out.println("あなたは"+temp+"に石を置きました");
							break;
						}
						else {
							System.out.println("その場所には石を置くことができません");
						}
					}
				}
				board.setStone("⚫️", set);
			}
			else {
				System.out.println("あなたは石を置く場所がありませんでした");
				playerCanSet = false;
			}


			//AIの処理----------
			board.print();
			System.out.println("---------------------------------------------------");
			board.findSetPoints("⚪️");
			if (board.whiteList.size() != 0) {

				Collections.sort(board.whiteList, Comparator.comparing(RevList::getRevNum));
				Point p = null;

				if (AI == 0) {
					p = board.whiteList.get(0).getCenterPoint();
				}
				else if (AI == 1) {
					p = board.whiteList.get(board.whiteList.size()-1).getCenterPoint();
				}

				System.out.println("AIは"+p.getY()+(char)(p.getX()+96)+"に石を置きました");
				board.setStone("⚪️", p);
				board.revStone("⚪️", p.getY(), p.getX());
			}
			else {
				System.out.println("AIは石を置く場所がありませんでした");
				enemyCanSet = false;
			}


			//ゲーム終了判定
			if (playerCanSet==false && enemyCanSet==false) {
				break;
			}


		}

		//対戦結果表示
		board.result();

	}
}