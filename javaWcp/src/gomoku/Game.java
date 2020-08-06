package gomoku;
public class Game {
    Stone stone = new Stone();
    Judge judge = new Judge();
    Board board = new Board();

    //trueでゲーム継続、falseでゲーム終了
    private boolean gameLoop = true;
    public boolean isGameLoop() {
        return gameLoop;
    }
    public void setGameLoop(boolean gameLoop) {
        this.gameLoop = gameLoop;
    }

    //奇数の時は黒、偶数のときは白
    private int loop=1;
    public int getLoop() {
        return loop;
    }
    public void setLoop(int loop) {
        this.loop = loop;
    }

    public void gameStart() {
        board.firstShowBoard();

        while(isGameLoop()) {
            //gameLoopがtrueの場合ゲーム継続
            if(getLoop()%2 == 1) {
                //loopが奇数のときは黒
                System.out.println("黒の番です");
                //引数にtrueで黒の手番
                stone.stoneConfig(true);
                if(stone.getStoneSet()) {
                    if(!judge.winJudge()) {
                    //winJudgeがfalseでゲーム継続、trueで勝利判定
                    //stoneSetがtrueで次の白の番に以降
                    setLoop(2);
                    }
                    else {
                        System.out.println("黒の勝利です！\nゲームを終了します!");
                        setGameLoop(false);
                    }
                }
                else {
                    setLoop(1);
                }
            }
            //loopが偶数の時は白
            else{
                System.out.println("白の番です");
                stone.stoneConfig(false);

                if(stone.getStoneSet()) {
                    if(!judge.winJudge()) {
                        //winJudgeがfalseでゲーム継続、trueで勝利判定
                        //stoneSetがtrueで次の白の番に以降
                        setLoop(1);
                        }
                        else {
                            System.out.println("白の勝利です！\nゲームを終了します!");
                            setGameLoop(false);
                        }
                    //stoneSetがtrueで黒の番に移行
                    }
                else {
                    setLoop(2);
                }
            }

        }
    }


}