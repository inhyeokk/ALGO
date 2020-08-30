package programmers;
import java.util.HashMap;
import java.util.Map;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/64063
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @idea	union-find 
 * 			key가 없거나 현재와 같으면 다음 위치의 key와 union
 */
public class PRO_L4_호텔방배정 {
	private final Map<Long, Long> map = new HashMap<>();
	public long[] solution(long k, long[] room_number) {
		int len = room_number.length;
		long[] answer = new long[len];
		for (int i = 0; i < len; ++i) {
			if (!map.containsKey(room_number[i]) || map.get(room_number[i]) == room_number[i]) {
				answer[i] = room_number[i];
				map.put(room_number[i], find(room_number[i]+1));
			} else {
				answer[i] = find(room_number[i]);
				map.put(answer[i], find(answer[i]+1));
			}
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
