package gomoku;

public class Board implements Constant{
	private int tate = 0;
	  private int yoko = 0;
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

    public void firstShowBoard() {
    	String [][] board = new String[tate][yoko];

        System.out.println("\n\t0\t1\t2\t3\t4\t5\t6\t7\n");
        for(int y=0;y<board.length;y++){
            System.out.print(y+"\t");
            for(int x=0;x<board[0].length;x++){
              String b = board[y][x];
              System.out.print(b+"\t");
            }
            System.out.println("\n");
          }
        //position配列のすべての座標に"□"を格納し
        //position参照時のnullを防ぐ
//        for(int i=0; i<BOARD_LENGTH;i++) {
//            for(int j=0; j<BOARD_LENGTH; j++) {
//                setPosition(i,j,EMPTY_STONE);
//                System.out.print(EMPTY_STONE);
//            }
//            System.out.println("");
//        }
    }

    //碁盤作成メソッド
    public void board(int tate, int yoko, boolean stoneColor) {
        //stoneColorがtrueで黒,falseで白
        setStoneColor(stoneColor);

        for(int i=0; i<BOARD_LENGTH; i++) {
            //for文の変数iは縦を意味する
            for(int j=0; j<BOARD_LENGTH; j++) {
                //for文の変数jは横を意味する
                if((i==tate) && (j==yoko)) {
                    if(isStoneColor()) {
                        setPosition(tate,yoko,BLACK_STONE);
                        System.out.print(getPosition(tate,yoko));
                    }
                    else{
                        setPosition(tate,yoko,WHITE_STONE);
                        System.out.print(getPosition(tate,yoko));
                    }
                }
                else {
                    System.out.print(getPosition(i,j));
                }
            }
            System.out.println("");
        }
    }
}
