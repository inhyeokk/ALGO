package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/64061
 * @date   	2020-05-09
 * @author 	rkddlsgur983
 * @idea	징검다리를 건널 수 있는 사람 수에 대한 이진탐색
 */
public class PRO_L3_징검다리건너기 {
	public int solution(int[] stones, int k) {
		int min = 200000000;
		int max = 1;
		for (int i = 0, len = stones.length; i < len; ++i) {
			min = Math.min(stones[i], min);
			max = Math.max(stones[i], max);
		}
        int answer = 0;
        while (min <= max) {
        	int mid = (min+max)/2;
        	boolean go = true;
        	int cnt = 0;
        	for (int i = 0, len = stones.length; i < len; ++i) {
        		if (stones[i]-mid < 0) {
        			++cnt;
        			if (cnt == k) {
        				go = false;
        				break;
        			}
        		} else {
        			cnt = 0;
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
