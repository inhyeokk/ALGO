import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-03
 * @author 	rkddlsgur983
 * @memory 	18400KB / 256MB
 * @time   	115ms / 2초
 * @idea	시뮬레이션
 */
public class SWEA_D4_9659_다항식계산 {
	private static int n, MOD = 998244353;
	private static int[][] input;
	private static long[] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			n = Integer.parseInt(br.readLine());
			input = new int[n+1][3];
			for (int i = 2; i <= n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
				input[i][2] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			sb.append("#").append(t).append(" ");
			memo = new long[n+1];
			for (int i = 0; i < m; ++i) {
				int x = Integer.parseInt(st.nextToken());
				Arrays.fill(memo, -1);
				sb.append(recur(n, x)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static long recur(int i, int x) {
		if (i == 0) {
			return 1;
		}
		if (i == 1) {
			return x;
		}
		if (memo[i] != -1) {
			return memo[i];
		}
		switch(input[i][0]) {
			case 1:
				memo[i] = (recur(input[i][1], x) + recur(input[i][2], x))%MOD;
				break;
			case 2:
				memo[i] = ((long)input[i][1] * recur(input[i][2], x))%MOD;
				break;
			case 3:
				memo[i] =  (recur(input[i][1], x) * recur(input[i][2], x))%MOD;
				break;
		}
		return memo[i];
	}
}
