package programmers.sk;

class Solution3 {
    public int solution(int n, int[][] d, int k) {
		int cur = k;
		for (int[] m: d) {
			if (m[0] == cur) {
				cur = m[1];
			} else if (m[1] == cur) {
				cur = m[0];
			}
		}
        int answer = cur;
        return answer;
    }
}