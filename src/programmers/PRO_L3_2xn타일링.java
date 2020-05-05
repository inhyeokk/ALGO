package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12900
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 */
public class PRO_L3_2xn타일링 {
	private int mod = 1000000007;
	public int solution(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; ++i) {
			dp[i] = (dp[i-2] + dp[i-1])%mod;
		}
        int answer = dp[n-1];
        return answer;
    }
}
