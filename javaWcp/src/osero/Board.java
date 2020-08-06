package osero;

import java.util.ArrayList;

public class Board {

	private String[][] board = {

			{"　","a ","ｂ ","ｃ ","ｄ ","ｅ ","ｆ ","ｇ ","ｈ ","　"},
			{"１","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"２","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"３","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"４","ー ","ー ","ー ","⚪️" ,"⚫️" ,"ー ","ー ","ー ","　"},
			{"５","ー ","ー ","ー ","⚫️" ,"⚪️" ,"ー ","ー ","ー ","　"},
			{"６","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"７","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"８","ー ","ー ","ー ","ー ","ー ","ー ","ー ","ー ","　"},
			{"　","　","　","　","　","　","　","　","　","　"}
	};

	private Here[] D8 = {
			new Here(-1, -1), new Here(-1, 0), new Here(-1, 1),
			new Here( 0, -1),                   new Here( 0, 1),
			new Here( 1, -1), new Here( 1, 0), new Here( 1, 1)
	};

	ArrayList<RevList> whiteList = new ArrayList<>();
	ArrayList<RevList> blackList = new ArrayList<>();

	//相手の石の色を取得するメソッド
	public String getEnemyStone (String stone) {
		if (stone.equals("⚪️")) return "⚫️";
		else return "⚪️";
	}

	public void findSetHeres (String stone) {
		if (stone.equals("⚫️")) {
			blackList.clear();
		}
		else {
			whiteList.clear();
		}

		for (int i=1; i<=8; i++) {
			for (int j=1; j<=8; j++) {

				//石がすでに置いてある場合はcontinue
				if (board[i][j].equals("ー ") == false) continue;

				//まず周囲八方向を見る。相手の石が1個もなければcontinue
				boolean around = false;
				for (int k=0; k<8; k++) {
					if (board[i+D8[k].getY()][j+D8[k].getX()].equals(getEnemyStone(stone))) {
						around = true;
					}
				}
				if (around == false) continue;

				//1個以上相手の石があるので、探索を開始する
				RevList revList = new RevList(new Here(i, j));

				for (int k=0; k<8; k++) {

					Here nowP = revList.getCenterHere();
					ArrayList<Here> tempHeres = new ArrayList<>();
					boolean canCapture = false;

					//八方向に伸ばしていって、相手の石を挟めるかどうか探索する
					while (true) {
						nowP.move(D8[k]);
						if (board[nowP.getY()][nowP.getX()].equals(getEnemyStone(stone)) == true) {
							tempHeres.add(new Here(nowP.getY(), nowP.getX()));
						}
						else if (board[nowP.getY()][nowP.getX()].equals(stone) == true) {
							if (tempHeres.size() > 0) {
								canCapture = true;
								break;
							}
							else {
								canCapture = false;
								break;
							}
						}
						else {
							canCapture = false;
							break;
						}
					}

					//自分の石がなければcontinue
					if (canCapture == false) continue;

					revList.addRevHere(tempHeres);

				}

				//1個以上の相手の石を裏返せる場合のみ、リストに追加
				if (revList.getRevNum() > 0) {
					if (stone.equals("⚫️")) {
						blackList.add(revList);
					}
					else {
						whiteList.add(revList);
					}
				}

			}
		}
	}

	//プレイヤー が選んだ位置がリストに含まれているかを判定するメソッド
	public boolean containSetHeres (int y, int x) {
		for (int i=0; i<blackList.size(); i++) {
			if (blackList.get(i).getCenterY()==y && blackList.get(i).getCenterX()==x) {
				return true;
			}
		}
		return false;
	}

	//石を裏返すメソッド（Mapを使えば外側のルー プを外せそう）
	public void revStone (String stone, int y, int x) {
		if (stone.equals("⚪️")) {
			for (int i=0; i<whiteList.size(); i++) {
				if (whiteList.get(i).getCenterY()==y && whiteList.get(i).getCenterX()==x) {
					ArrayList<Here> list = whiteList.get(i).getRevHeres();
					for (int j=0; j<list.size(); j++) {
						board[list.get(j).getY()][list.get(j).getX()] = stone;
					}
					return;
				}
			}
		}
		else {
			for (int i=0; i<blackList.size(); i++) {
				if (blackList.get(i).getCenterY()==y && blackList.get(i).getCenterX()==x) {
					ArrayList<Here> list = blackList.get(i).getRevHeres();
					for (int j=0; j<list.size(); j++) {
						board[list.get(j).getY()][list.get(j).getX()] = stone;
					}
					return;
				}
			}
		}
	}

	//石を置くメソッド（上のrevStoneと一緒にしてしまえそう）
	public void setStone (String stone, Here p) {
		board[p.getY()][p.getX()] = stone;
	}

	public void print () {
		for (int i=0; i<=9; i++) {
			for (int j=0; j<=9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

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