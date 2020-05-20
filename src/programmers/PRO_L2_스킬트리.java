package programmers;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/49993
 * @date	2020-05-20
 * @author	rkddlsgur983
 * @idea	skill의 i위치보다 뒤에 있는 문자를 먼저 만나면 불가능
 */
public class PRO_L2_스킬트리 {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int ilen = skill.length();
        for (String s: skill_trees) {
        	int i = 0, j = 0, jlen = s.length();
        	boolean go = true;
        	here:
        	for (; i < ilen && j < jlen; ++j) {
        		if (skill.charAt(i) == s.charAt(j)) {
        			++i;
        			continue;
        		}
        		for (int k = i+1; k < ilen; ++k) {
        			if (skill.charAt(k) == s.charAt(j)) {
        				go = false;
        				break here;
        			}
        		}
        	}
        	if (go) ++answer;
        }
        return answer;
    }
}
