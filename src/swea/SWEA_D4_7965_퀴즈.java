package swea;
import java.util.Scanner;

public class SWEA_D4_7965_퀴즈 {
	private static final int N = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		long[] memo = new long[1000001];
		int[] arr = new int[t];
		int max = 0;
		for (int i = 0; i < t; ++i) {
			arr[i] = sc.nextInt();
			max = max < arr[i] ? arr[i] : max;
		}
		for (int i = 1; i <= max; ++i) {
			memo[i] = (memo[i-1] + pow(i,i))%N;
		}
		for (int i = 0; i < t; ++i) {
			sb.append("#").append(i+1).append(" ").append(memo[arr[i]]).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
	
	private static long pow(long base, int power) {
		
		long result = 1L;
		while (power > 0) {
			if (power % 2 == 1) {
				result = result * base % N;
			}
			power /= 2;
			base = base * base % N;
		}
		return result;
	}
}
