package osero;

public class Game {
	public static void main(String[] args) {
		Field field = new Field(6,6);
		field.prepare();
		field.putKoma(2,2,"●");
		field.feature();
	}
}
