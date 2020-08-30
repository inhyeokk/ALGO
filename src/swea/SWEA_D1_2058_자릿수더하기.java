package swea;

import java.util.Scanner;

public class SWEA_D1_2058_자릿수더하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int input = sc.nextInt();
		int sum = 0;
		while (input >= 10) {
			sum += input % 10;
			input /= 10;
		}
		sum += input;
		System.out.println(sum);
		sc.close();
	}
	
	private static final String src = "6789";
}
