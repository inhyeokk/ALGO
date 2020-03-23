
/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/17687
 * @date   2020-03-16
 * @author rkddlsgur983
 */
public class PRO_L2_3차_n진수게임 {
	public String solution(int n, int t, int m, int p) {
		String answer = "";
		int i = 0, len = 0, c = 0;
		while (true) {
			String s = getNum(i, n);
			for (int j = 0, l = s.length(); j < l; ++j) {
				if (c == p-1) {
					answer += s.charAt(j);
					++len;
					if (len == t) {
						return answer;
					}
				}
				++c;
				if (c == m) c = 0;
			}
			++i;
		}
	}
	
	/**
	 * @param x
	 * @param n
	 * @return 10진수 x를 n진수로 변환
	 */
	private String getNum(int x, int n) {
		
		int i = 0;
		while (x >= Math.pow(n, i+1)) {
			++i;
		}
		
		String s = "";
		for (; i >= 0; --i) {
			int p = (int)Math.pow(n, i);
			int t = x / p;
			x %= p;
			if (t >= 10) {
				s += (char)(t-10+'A');
			} else {
				s += (char)(t+'0');
			}
		}
		return s;
	}
}
