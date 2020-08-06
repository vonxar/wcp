package gomoku;

import java.util.ArrayList;

public class RevList2 {
	private Here center;
	private ArrayList<Here> revHeres = new ArrayList<>();

	RevList2 (Here p) {
		center = new Here(p.getY(), p.getX());
	}

	public Here getCenterHere () {
		return new Here(center.getY(), center.getX());
	}

	public void addRevHere (ArrayList<Here> list) {
		if (list.size() > 0) revHeres.addAll(list);
	}

	public ArrayList<Here> getRevHeres () {return revHeres;}

	public  int getCenterY() {return center.getY();}

	public int getCenterX() {return center.getX();}

	public int getRevNum () {return revHeres.size();}

}