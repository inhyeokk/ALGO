package programmers;

import java.util.Arrays;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12987
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	A의 순서가 정해져 있다는 것은 낚시
 * 			A와 B를 오름차순 정렬하고 B가 이길때마다 i를 같이 증가시키는데 이 값이 최대 승점과 같다.
 */
public class PRO_L3_숫자게임 {
	public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for (int i = 0, j = 0, len = A.length; j < len; ++j) {
        	if (A[i] < B[j]) {
        		++i;
        		++answer;
        	}
        }
        return answer;
    }
}
