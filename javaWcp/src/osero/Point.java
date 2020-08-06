package osero;

public class Point {

	private int y, x;

	Point (int a, int b) {
		y = a;
		x = b;
	}

	public int getY () {return y;}

	public int getX () {return x;}

	public void move (Point p) {
		y += p.getY();
		x += p.getX();
	}

//	結果
	public void result () {
		System.out.println();
		System.out.println("ゲー ムが終了しました。結果は……");
		print();

		int blackNum = 0, whiteNum = 0;
		for (int i=1; i<=8; i++) {
			for (int j=1; j<=8; j++) {
				if (board[i][j].equals("⚪️")) whiteNum++;
				else if (board[i][j].equals("⚫️")) blackNum++;
			}
		}

		if (blackNum == whiteNum) {
			System.out.println(blackNum+"対"+whiteNum+"で引き分けです！");
		}
		else if (blackNum > whiteNum) {
			System.out.println(blackNum+"対"+whiteNum+"でプレイヤー の勝利です！");
		}
		else {
			System.out.println(blackNum+"対"+whiteNum+"でAIの勝利です！");
		}

	}
}