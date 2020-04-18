package swea;
import java.util.Scanner;

public class SWEA_D3_8840_아바바바 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			long l = sc.nextInt();
			l = (l-1)/2;
			sb.append("#").append(i).append(" ").append(l*l).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
