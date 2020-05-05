package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12904
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 */
public class PRO_L3_가장긴팰린드롬 {	
	public int solution(String s) {
        int answer = 0;
        for (int i = 0, len = s.length(); i < len; ++i) {
        	int j = 1;
        	while (i-j >= 0 && i+j < len && s.charAt(i-j) == s.charAt(i+j)) {
        		++j;
        	}
        	answer = Math.max(j*2-1, answer);
        	j = 0;
        	while (i-j >= 0 && i+1+j < len && s.charAt(i-j) == s.charAt(i+1+j)) {
        		++j;
        	}
        	answer = Math.max(j*2, answer);
        }
        return answer;
    }
}
