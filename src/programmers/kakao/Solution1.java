package programmers.kakao;
import java.util.Stack;

public class Solution1 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int m: moves) {
        	for (int i = 0; i < board.length; ++i) {
        		int target = board[i][m-1];
        		if (target > 0) {
        			board[i][m-1] = 0;
        			if (!stack.isEmpty() && stack.peek() == target) {
        				answer += 2;
        				stack.pop();
        			} else {
            			stack.add(target);
        			}
            		break;
        		}
        	}
        }
        return answer;
    }
}
