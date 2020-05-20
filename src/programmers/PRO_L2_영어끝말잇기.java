package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12981
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	Set에 이미 말한 단어를 저장 / 중복이 나오면 종료
 * 			또는 이전 단어의 마지막 문자와 다르면 종료
 */
public class PRO_L2_영어끝말잇기 {
	public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<>();
        char before = ' ';
        for (int i = 0, len = words.length; i < len; ++i) {
        	if ((before == ' ' || before == words[i].charAt(0)) && !set.contains(words[i])) {
        		before = words[i].charAt(words[i].length()-1);
        		set.add(words[i]);
        	} else {
        		answer[0] = i%n+1;
        		answer[1] = i/n;
        		break;
        	}
        }
        return answer;
    }
}
