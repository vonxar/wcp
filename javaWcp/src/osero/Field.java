package osero;

import java.util.ArrayList;
import java.util.List;

public class Field {
	private List<Koma> komalist;
	private int ynum = 0;
	private int xnum = 0;
	
	public Field(int xnum, int ynum) {
		this.xnum = xnum;
		this.ynum = ynum;
	}
	public void prepare() {
		this.komalist = new ArrayList<>();
		for(int y=0; y<this.ynum; y++) {
		for(int x=0; x<this.xnum; x++) {
			Koma koma = new Koma(x,y);
			this.komalist.add(koma);
		}
		}
	}
	public Koma getkoma(int y,int x) {
		for(Koma koma : this.komalist) {
			int[]pos = koma.getPosition();
			if(pos[0] == y && pos[1] == x ) {
				return koma;
			}
		}
		return null;
	}
	public void putKoma(int x, int y, String state) {
		Koma koma = this.getkoma(x, y);
		koma.setState(state);
	}
	public void feature() {
		String [] [] board = new String[ynum][xnum];
		for(Koma koma : this.komalist) {
			int[] pos = koma.getPosition();
			String state = koma.getState();
			board[pos[1]][pos[0]] = state;
		}
		System.out.println("\n\t0\t1\t2\t3\t4\t5\n");
		for(int y=0;y<board.length;y++){
			System.out.print(y+"\t");
			for(int x=0;x<board[0].length;x++){
				String b = board[y][x];
				System.out.print(b+"\t");
			}
			System.out.println("\n");
		}
	}
 }