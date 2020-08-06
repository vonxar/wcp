package gomoku;

public class Field implements Constant{
	//石の位置を保存
    private static String[][] position = new String[BOARD_LENGTH][BOARD_LENGTH];
    public static void setPosition(int tate, int yoko, String stone) {
        position[tate][yoko] = stone;
    }
    public static String getPosition(int tate, int yoko) {
        return position[tate][yoko];
    }
  //trueなら黒、falseなら白
    private Boolean stoneColor;
    public Boolean isStoneColor() {
        return stoneColor;
    }
    public void setStoneColor(Boolean stoneColor) {
        this.stoneColor = stoneColor;
    }
    
public void feature(){
    String [][] field = new String[tate][yoko];
    for(Koma koma : this.komalist){
      int[] pos = koma.getPosition();
      String state = koma.getState();
      field[pos[1]][pos[0]] = state;
    }
    System.out.println("\n\t0\t1\t2\t3\t4\t5\t6\t7\n");
    for(int y=0;y<field.length;y++){
      System.out.print(y+"\t");
      for(int x=0;x<field[0].length;x++){
        String b = field[y][x];
        System.out.print(b+"\t");
      }
      System.out.println("\n");
    }
  }
	public void result () {
		System.out.println();
		System.out.println("ゲー ムが終了しました。結果は……");
		feature();

//		if (==) {
//			System.out.println(blackNum+"対"+whiteNum+"で引き分けです！");
//		}
//		else if (blackNum > whiteNum) {
//			System.out.println(blackNum+"対"+whiteNum+"でプレイヤー の勝利です！");
//		}
//		else {
//			System.out.println(blackNum+"対"+whiteNum+"でAIの勝利です！");
//		}
//
	}
}