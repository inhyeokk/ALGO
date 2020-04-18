package programmers;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/17684
 * @date   	2020-03-17
 * @author 	rkddlsgur983
 * @idea	시뮬레이션
 */
public class PRO_L2_3차_압축 {
	public int[] solution(String msg) {
		HashMap<String, Integer> map = new HashMap<>();
		int cnt = 0;
		while (cnt < 27) {
			map.put(""+(char)('A'+cnt), ++cnt);
		}
		Queue<Integer> queue = new LinkedList<>();
		int i = 0, len = msg.length();
		while (i < len) {
			int j = i+2;
			while (j <= len && map.containsKey(msg.substring(i,j))) {
				++j;
			}
			if (j > len) {
				queue.add(map.get(msg.substring(i,len)));
				i = len;
			} else {
				queue.add(map.get(msg.substring(i, j-1)));
				map.put(msg.substring(i, j), cnt++);
				i = j-1;
			}
		}
		int size = queue.size();
	    int[] answer = new int[size];
	    for (i = 0; i < size; ++i) {
	    	answer[i] = queue.poll();
	    }
	    return answer;
	}
}
