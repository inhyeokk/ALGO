package programmers;
import java.util.HashMap;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/17683
 * @date   	2020-03-19
 * @author 	rkddlsgur983
 * @idea	문자열 시뮬레이션
 */
public class PRO_L2_3차_방금그곡 {
	private final HashMap<String, Character> map = new HashMap<>();
	public String solution(String m, String[] musicinfos) {
		map.put("A#", 'H');
		map.put("C#", 'I');
		map.put("D#", 'J');
		map.put("F#", 'K');
		map.put("G#", 'L');
		
		m = transform(m);
		int max = 0;
		String ans = "(None)";
		for (String music: musicinfos) {
			String[] split = music.split(",");
			int st = getTime(split[0]); // 시작 시각
			int et = getTime(split[1]); // 끝난 시각
			String title = split[2];
			String info = transform(split[3]);
			
			int time = et - st;
			int len = info.length();
			int share = time / len;
			int remain = time % len;
			String s = "";
			for (int i = 0; i < share; ++i) {
				s += info;
			}
			for (int i = 0; i < remain; ++i) {
				s += info.charAt(i);
			}
			if (s.contains(m)) {
				if (max < time) {
					max = time;
					ans = title;
				}
			}

			/*char[] c = new char[time];
			for (int j = 0, k = 0, len = info.length(); j < time; ++j) {
				c[j] = info.charAt(k++);
				if (k == len) k = 0;
			}
			here:
			for (int j = 0, len = m.length(); j < time; ++j) {
				int cnt = 0;
				int k = j;
				while (m.charAt(cnt++) == c[k++]) {
					if (cnt == len) {
						if (max < time) {
							max = time;
							ans = title;
						}
						break here;
					}
					if (k == time) break;
				}
			}*/
		}
		return ans;
	}
	
	private String transform(String s) {
		String str = "";
		for (int i = 0, len = s.length(); i < len;) {
			if (i+1 < len && s.charAt(i+1) == '#') {
				str += map.get(s.substring(i, i+2));
				i+=2;
			} else {
				str += s.charAt(i++);
			}
		}
		return str;
	}
	
	private int getTime(String s) {
		int h = Integer.parseInt(s.substring(0,2));
		int time = h*60;
		int m = Integer.parseInt(s.substring(3));
		time += m;
		return time;
	}
}
