package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/43237
 * @date   	2020-05-09
 * @author 	rkddlsgur983
 * @idea	이진탐색
 */
public class PRO_L3_예산 {
	public int solution(int[] budgets, int M) {
		int len = budgets.length;
		int min = 1;
		int max = len;
		for (int i = 0; i < len; ++i) {
			max = Math.max(budgets[i], max);
		}
        int answer = 0;
		while (min <= max) {
			int mid = (min+max)/2;
			boolean go = true;
			int sum = 0;
			for (int i = 0; i < len; ++i) {
				if (budgets[i] > mid) {
					sum += mid;
				} else {
					sum += budgets[i];
				}
				if (sum > M) {
					go = false;
					break;
				}
			}
			if (go) {
				answer = mid;
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
        return answer;
    }
}
