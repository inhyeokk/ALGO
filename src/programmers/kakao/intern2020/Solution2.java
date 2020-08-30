package programmers.kakao.intern2020;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {
	private final char[][] order = {
			{'*','+','-'},{'*','-','+'},
			{'+','*','-'},{'+','-','*'},
			{'-','+','*'},{'-','*','+'},
	};
	public long solution(String expression) {
		List<Long> num = new ArrayList<>();
		List<Character> or = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(expression, "+-*");
		while (st.hasMoreTokens()) {
			num.add(Long.parseLong(st.nextToken()));
		}
		for (int i = 0, len = expression.length(); i < len; ++i) {
			if (expression.charAt(i) == '+' 
					|| expression.charAt(i) == '-'
					|| expression.charAt(i) == '*') {
				or.add(expression.charAt(i));
			}
		}
        long answer = 0;
		for (int i = 0, s = order.length; i < s; ++i) {
			List<Long> tn = new ArrayList<>(num.size());
			for (Long t: num) {
				tn.add(t);
			}
			List<Character> to = new ArrayList<>(or.size());
			for (Character t: or) {
				to.add(t);
			}
			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < to.size();) {
					if (to.get(k) == order[i][j]) {
						char o = to.remove(k);
						long a = tn.remove(k);
						long b = tn.remove(k);
						tn.add(k, cal(a,b,o));
					} else {
						++k;
					}
				}
			}
			answer = Math.max(Math.abs(tn.get(0)), answer);
		}
        return answer;
    }
	
	private long cal(long a, long b, char o) {
		switch (o) {
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
		}
		return 0;
	}
}

