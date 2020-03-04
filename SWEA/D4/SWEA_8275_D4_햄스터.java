import java.util.Scanner;

/**
 * @date   2020-03-04
 * @author rkddlsgur983
 * @memory 32824KB / 262144KB
 * @time   677ms / 8초
 */
public class SWEA_8275_D4_햄스터 {
	private static int[][] marr = new int[10][3];
	private static int[] hamster = new int[6];
	private static int n, x, m;
	private static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			n = sc.nextInt();
			x = sc.nextInt();
			m = sc.nextInt();
			for (int j = 0; j < m; ++j) {
				marr[j][0] = sc.nextInt()-1;
				marr[j][1] = sc.nextInt()-1;
				marr[j][2] = sc.nextInt();
			}
			max = -1;
			combination(0, new int[n], 0);
			sb.append("#").append(i).append(" ");
			if (max == -1) {
				sb.append(-1);
			} else {
				for (int j = 0; j < n; ++j) {
					sb.append(hamster[j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
	
	private static void combination(int depth, int[] tmp, int sum) {
		
		if (depth == n) {
			if (max < sum) {
				for (int i = 0; i < m; ++i) {
					int tsum = 0;
					for (int j = marr[i][0]; j <= marr[i][1]; ++j) {
						tsum += tmp[j];
					}
					if (marr[i][2] != tsum) {
						return;
					}
				}
				max = sum;
				for (int i = 0; i < n; ++i) {
					hamster[i] = tmp[i];
				}
			}
			return;
		}
		
		for (int i = 0; i <= x; ++i) {
			tmp[depth] = i;
			combination(depth+1, tmp, sum+i);
		}
	}
}
