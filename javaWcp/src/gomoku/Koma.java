package gomoku;

public class Koma{
    private String state; // オセロの色が黒…●、白…◯、空…-
    private int x;
    private int y;

    public Koma(int x,int y){
        this.state = "-";
        this.x = x;
        this.y = y;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public int[] getPosition(){
        int[]pos = {this.x, this.y};
        return pos;
    }

}