package test;
import java.util.Scanner;

public class test {
	public static Scanner sc = new Scanner(System.in); //入力待ち
	public static void main(String[] args){
	int[] black = new int[5];
	int green = 0;
	int[][] ban = new int[8][8];

	while (true) {
	System.out.println("数字を入れてください");
	String suzi = sc.next(); //入力を取得
	int s = Integer.valueOf(suzi);
	 black =tasu.aaa(s,10);
		System.out.println(black[0]);
		System.out.println(black[1]);
	}
	}
}
