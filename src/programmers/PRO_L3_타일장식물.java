package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/43104
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 */
public class PRO_L3_타일장식물 {
	public static long solution(int N) {
		long[] dp = new long[N];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < N; ++i) {
			dp[i] = dp[i-2] + dp[i-1];
		}
        long answer = dp[N-1]*4+dp[N-2]*2;
        return answer;
    }
}
