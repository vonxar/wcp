package gomoku;

public class Here {
	
	private int y, x; //定義
	
	Here (int a, int b) { //コンストラクタ
		y = a;
		x = b;
	}
	
	public int getY () {return y;} //getメソッド　yを取得
	
	public int getX () {return x;} // getメソッド　x取得
	
	public void move (Here p) {
		y += p.getY();
		x += p.getX();
	}
}