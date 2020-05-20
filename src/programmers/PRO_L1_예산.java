package programmers;

import java.util.Arrays;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12982
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	정렬 후 합을 더해가면서 가능한 인덱스 저장
 */
public class PRO_L1_예산 {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
        int answer = 0, sum = 0;
        for (int i = 0, len = d.length; i < len; ++i) {
        	if (sum + d[i] <= budget) {
        		sum += d[i];
                answer = i+1;
        	} else {
        		break;
        	}
        }
        return answer;
    }
}
