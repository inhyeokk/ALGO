package programmers;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/62049
 * @date   	2020-05-19
 * @author 	rkddlsgur983
 * @idea	규칙찾기, 이진트리 중위순회
 */
public class PRO_L3_종이접기 {
	public int[] solution(int n) {
		int v = (int)(Math.pow(2, n)-1);
		int[] answer = new int[v];
        for (int i = 1; i < n; ++i) {
        	int k = (int) (Math.pow(2, i)-1);
        	int l = (int) (Math.pow(2, i+1)-2);
        	for (int j = 0; j < k; ++j) {
        		answer[l-j] = answer[j] == 0 ? 1 : 0;
        	}
        }
        return answer;
    }
}
