package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-02-28
 * @author rkddlsgur983
 * @memory 102240KB
 * @time   269ms
 */
public class SWEA_D3_5642_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[100000];
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), " ");
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < n; ++j) {
				dp[j] = Integer.parseInt(st.nextToken());
				if (j >= 1) {
					/* 이전 값이 음수인경우 현재 값과 더할 필요 없음
					 * 이전까지 합과 현재 값을 더한 값이 양수인 경우 더함
					 */
					if (dp[j-1] > 0 && dp[j] + dp[j-1] > 0) {
						dp[j] += dp[j-1];
					}
				}
				max = max < dp[j] ? dp[j] : max;
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
