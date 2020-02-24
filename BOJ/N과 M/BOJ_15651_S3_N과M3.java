import java.util.Scanner;

public class S3_15651_N과M3 {
	private static StringBuilder sb = new StringBuilder();
	private static int n, m;
	private static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = i+1;
		}
		permutation(0, new int[n]);
		System.out.print(sb);
		sc.close();
	}
	
	private static void permutation(int depth, int[] tmp) {
		
		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			tmp[depth] = arr[i];
			permutation(depth+1, tmp);
		}
	}
}
