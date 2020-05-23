package programmers.sk;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
	public int solution(int[] gift_cards, int[] wants) {
		int len = wants.length;
        List<Integer> list_wants = new ArrayList<>(len);
        for (int i = 0; i < len; ++i) {
        	list_wants.add(wants[i]);
        }
        int answer = 0;
        for (int i = 0; i < len; ++i) {
        	if (list_wants.contains(gift_cards[i])) {
        		list_wants.remove(Integer.valueOf(gift_cards[i]));
        		if (list_wants.isEmpty()) {
        			answer += len-(i+1);
        			break;
        		}
        	} else {
        		++answer;
        	}
        }
        return answer;
    }
}
