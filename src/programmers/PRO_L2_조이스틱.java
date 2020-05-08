package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/42860
 * @date   	2020-05-09
 * @author 	rkddlsgur983
 * @idea	탐욕법
 */
public class PRO_L2_조이스틱 {
	public int solution(String name) {
		char[] str = name.toCharArray();
		int answer = 0, i = 0, len = str.length;
        while (true) {
        	char c = str[i];
        	if (c != 'A') {
        		if (c >= 'B' && c <= 'N') {
        			answer += c-'A';
        		} else {
        			answer += 26-(c-'A');
        		}
        		str[i] = 'A';
        	}
        	boolean go = true;
        	for (int j = 0; j < len; ++j) {
        		if (str[j] != 'A') {
        			go = false;
        			break;
        		}
        	}
        	if (go) break;

    		// 오른쪽 or 왼쪽 비교해서 짧은 곳
        	int left = 1, right = 1;
        	for (; left <= len/2; ++left) {
        		if (str[(i+left)%len] != 'A') break;
        	}
        	for (; right <= len/2; ++right) {
        		if (str[i-right < 0 ? len+i-right : i-right] != 'A') break;
        	}
        	if (left <= right) {
        		i = (i+left)%len;
        		answer += left;
        	} else {
        		i = i-right < 0 ? len+i-right : i-right;
        		answer += right;
        	}
        }
		return answer;
    }
}
