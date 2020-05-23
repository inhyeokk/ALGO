package programmers.sk;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public int[] solution(int[] deposit) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0, len = deposit.length; i < len; ++i) {
			if (deposit[i] >= 0) {
				list.add(deposit[i]);
			} else {
				deposit[i] = -deposit[i];
				while (deposit[i] > 0 && !list.isEmpty()) {
					int last = list.size()-1;
					if (list.get(last) > deposit[i]) {
						int tmp = list.get(last) - deposit[i];
						list.remove(last);
						list.add(tmp);
						break;
					} else {
						deposit[i] -= list.get(last);
						list.remove(last);
					}
					
				}
			}
		}
		int size = list.size();
        int[] answer = new int[list.size()];
        for (int i = 0; i < size; ++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}