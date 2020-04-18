package programmers;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/17678
 * @date   2020-04-07
 * @author rkddlsgur983
 */
public class PRO_L3_1차_셔틀버스 {
	public String solution(int n, int t, int m, String[] timetable) {
		StringTokenizer st;
		List<Integer> list = new LinkedList<>();
		for (String time: timetable) {
			st = new StringTokenizer(time, ":");
			list.add(Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int time = 9*60;
		int last = 0;
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			while (cnt < m && !list.isEmpty() && list.get(0) <= time) {
				last = list.remove(0);
				++cnt;
			}
			if (list.isEmpty() || i == n-1) {
				if (cnt == m) {
					return String.format("%02d:%02d", --last/60, last%60);
				} else {
					return String.format("%02d:%02d", time/60, time%60);
				}
			}
			time += t;
		}
		return "";
	}
}
