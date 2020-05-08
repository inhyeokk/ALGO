package programmers;

import java.util.Stack;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/64061
 * @date   	2020-05-08
 * @author 	rkddlsgur983
 * @idea	스택
 */
public class PRO_L1_크레인인형뽑기게임 {
	public int solution(int[][] board, int[] moves) {
		Stack<Integer> s = new Stack<>();
        int answer = 0;
        for (int i = 0, len = moves.length; i < len; ++i) {
        	int m = moves[i]-1;
        	for (int j = 0, jlen = board.length; j < jlen; ++j) {
        		if (board[j][m] > 0) {
        			if (!s.isEmpty() && s.peek() == board[j][m]) {
        				s.pop();
        				answer += 2;
        			} else {
        				s.add(board[j][m]);
        			}
        			board[j][m] = 0;
        			break;
        		}
        	}
        }
        return answer;
    }
}
