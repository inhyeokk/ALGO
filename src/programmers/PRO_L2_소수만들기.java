package programmers;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/12977
 * @date	2020-05-20
 * @author	rkddlsgur983
 * @idea	최대 경우의 소수를 먼저 찾아두고 가능한 경우 확인
 */
public class PRO_L2_소수만들기 {
	public int solution(int[] nums) {
		boolean[] arr = new boolean[2999];
		for (int i = 2; i <= 2998; ++i) {
			if (!arr[i]) {
				for (int j = i+i; j <= 2998; j+=i) {
					arr[j] = true;
				}
			}
		}
        int answer = 0;
        for (int i = 0, len = nums.length; i < len-2; ++i) {
        	for (int j = i+1; j < len-1; ++j) {
        		for (int k = j+1; k < len; ++k) {
        			if (!arr[nums[i]+nums[j]+nums[k]]) {
        				++answer;
        			}
        		}
        	}
        }
        return answer;
    }
}
