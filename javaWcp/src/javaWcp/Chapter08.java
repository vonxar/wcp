package javaWcp;

public class Chapter08 {
	public static void main(String[] args) {
		int count = 1;
		while (count < 5) {
			count = count*count;
			System.out.println(count);
			count++;
		}
		int number[] = {1,12,13,46,48};
        for (int  a = 0; a < number.length; a++) {
        System.out.println(number[a]);
        }
        for (int g : number) {
	    if (g%2 == 0) {
        // countが2の場合、この後の処理をスキップ
        continue;
        }
        System.out.println(g);
      }
	}
}