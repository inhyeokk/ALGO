package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/43238
 * @date   	2020-05-09
 * @author 	rkddlsgur983
 * @idea	이진탐색
 */
public class PRO_L3_입국심사 {
	public long solution(int n, int[] times) {
        long min = 1;
        long max = 1;
        int len = times.length;
        for (int i = 0; i < len; ++i) {
        	max = Math.max(((long)times[i])*((long)n), max);
        }
		long answer = 0;
		while (min <= max) {
			long mid = (min+max)/2;
			long cnt = 0;
			for (int i = 0; i < len; ++i) {
				cnt += mid/(long)times[i];
				if (cnt >= n) break;
			}
			if (cnt >= n) {
				answer = mid;
				max = mid-1;
			} else {
				min = mid+1;
			}
		}
        return answer;
    }
}
