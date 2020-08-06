package javaWcp;

public class Chapter07 {
	public static void main(String[] args) {
		int km = 10;
		if (km <= 5) {
			System.out.println("とても近いです");
		} else if (km <= 10 ) {
			System.out.println("近いです");
		} else if (km <= 15) {
			System.out.println("遠いです");
		} else {
			System.out.println("とても遠いです");
		}
		
        String color = "yellow"; // 例としてyellowで初期化。他の色でも良い
        switch(color) {
          case "red" :
            System.out.println("赤信号です");
            break;
          case "yellow" :
            System.out.println("黄信号です");
            break;
          case "blue" :
            System.out.println("青信号です");
            break;
          default:
            System.out.println("信号の色ではありません");
        }
    }
}