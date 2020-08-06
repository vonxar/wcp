package gomoku;
public class Judge implements Constant{

    private int win = 0;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win += win;
    }
    public void resetWin() {
        this.win = 0;
    }


    public boolean winJudge() {
        //win変数が5か-5の総和を持った時trueを返し勝利判定とする

        //横列の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if(Board.getPosition(i, j)==BLACK_STONE) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE_STONE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //縦列の勝利判定
        for(int j=0; j<BOARD_LENGTH; j++){
            for(int i=0; i<BOARD_LENGTH; i++)
             {
                if(Board.getPosition(i, j)==BLACK_STONE) {
                    setWin(1);
                }
                else if(Board.getPosition(i, j)==WHITE_STONE) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }

            if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
                return true;
            }
            else {
                resetWin();
            }
        }

        //左斜め列の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if((i==j) && (Board.getPosition(i, j)==BLACK_STONE)) {
                    setWin(1);
                }
                else if((i==j) && (Board.getPosition(i, j)==WHITE_STONE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
            return true;
        }
        else {
            resetWin();
        }

        //右斜め列の勝利判定
        for(int i=0; i<BOARD_LENGTH; i++) {
            for(int j=0; j<BOARD_LENGTH; j++) {
                if((i+j == (BOARD_LENGTH - 1)) && (Board.getPosition(i, j)==BLACK_STONE)) {
                    setWin(1);
                }
                else if((i+j == (BOARD_LENGTH - 1)) && (Board.getPosition(i, j)==WHITE_STONE)) {
                    setWin(-1);
                }
                else {
                    setWin(0);
                }
            }
            }
        if((getWin()==BOARD_LENGTH) || (getWin()==(-BOARD_LENGTH))) {
            return true;
        }
        else {
            resetWin();
        }

        return false;
    }

    }