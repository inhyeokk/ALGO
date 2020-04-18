package programmers.kakao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution4 {
    public long[] solution(long k, long[] room_number) {
    	int len = room_number.length;
    	Map<Long, Long> map = new HashMap<>();
    	Set<Long> set = new HashSet<>();
    	Queue<Long> queue = new LinkedList<>();
        long[] answer = new long[len];
        for (int i = 0; i < len; ++i) {
        	for (long j = room_number[i]; j <= k; ++j) {
        		while (map.containsKey(j)) {
            		queue.add(j);
            		j = map.get(j);
            	}
        		while (!queue.isEmpty()) {
        			map.put(queue.poll(), j);
        		}
    			if (!set.contains(j)) {
    				answer[i] = j;
    				set.add(j);
    				while (!queue.isEmpty()) {
    					long q = queue.poll();
    					if (!map.containsKey(q) || map.get(q) < j+1) {
    						map.put(q, j+1);
    					}
    				}
    				break;
    			} else {
    				queue.add(j);
    			}
    		}
        }
        return answer;
    }
}