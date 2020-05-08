package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/64063
 * @date   	2020-05-08
 * @author 	rkddlsgur983
 * @idea	union-find 
 * 			key가 없거나 현재와 같으면 다음 위치의 key와 union
 */
public class PRO_L4_호텔방배정2 {
	private Map<Long, Long> map = new HashMap<>();
	public long[] solution(long k, long[] room_number) {
		int len = room_number.length;
        long[] answer = new long[len];
        for (int i = 0; i < len; ++i) {
        	answer[i] = find(room_number[i]);
        	map.put(room_number[i], answer[i]+1);
        	map.put(answer[i], answer[i]+1);
        }
        return answer;
    }
	
	private long find(long x) {
		if (!map.containsKey(x) || map.get(x) == x) {
			return x;
		}
		map.put(x, find(map.get(x)));
		return map.get(x);
	}
}
