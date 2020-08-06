package gomoku;

public class Stone implements Constant{
    Board board = new Board();


    //石が正常に置けたらtrue,置けなかったらfalse
    private boolean stoneSet;
    public boolean getStoneSet() {
        return stoneSet;
    }
    public void setStoneSet(boolean stoneSet) {
        this.stoneSet = stoneSet;
    }


    //石の位置に関するフィールド
    private int tatePosition;
    private int yokoPosition;
    public int getTatePosition() {
        return tatePosition;
    }
    public void setTatePosition(int tatePosition) {
        this.tatePosition = tatePosition;
    }
    public int getYokoPosition() {
        return yokoPosition;
    }
    public void setYokoPosition(int yokoPosition) {
        this.yokoPosition = yokoPosition;
    }


    //石配置処理
    @SuppressWarnings("resource")
    public void stoneConfig(boolean stoneColor) {
        //引数stoneColorがtrueで黒、falseで白
        System.out.println("石の位置を入力してください");
        try {
        int tatePosition = new java.util.Scanner(System.in).nextInt();
        int yokoPosition = new java.util.Scanner(System.in).nextInt();
        if((tatePosition>=0&&yokoPosition>=0)&&(tatePosition<BOARD_LENGTH && yokoPosition<BOARD_LENGTH)) {
            if(Board.getPosition(tatePosition, yokoPosition)==EMPTY_STONE) {
                setTatePosition(tatePosition);
                setYokoPosition(yokoPosition);
                board.board(getTatePosition(), getYokoPosition(), stoneColor);
                setStoneSet(true);
            }
            else {
                setStoneSet(false);
                System.out.println("石が置かれていない場所を選択してください");
            }
        }
        else {
            setStoneSet(false);
            System.out.println("0～"+(BOARD_LENGTH-1)+"のどれかで入力してください");
        }
        }
        catch(Exception e) {
            setStoneSet(false);
            System.out.println("整数で入力してください");
        }
    }

}