package programmers.line;

public class Solution1 {
	public int solution(String inputString) {
		int a = 0, b = 0, c = 0, d = 0;
        int answer = 0;
		for (int i = 0, len = inputString.length(); i < len; ++i) {
			switch (inputString.charAt(i)) {
			case '(':
				++a;
				break;
			case ')':
				if (a == 0) return -1;
				--a;
				++answer;
				break;
			case '{':
				++b;
				break;
			case '}':
				if (b == 0) return -1;
				--b;
				++answer;
				break;
			case '[':
				++c;
				break;
			case ']':
				if (c == 0) return -1;
				--c;
				++answer;
				break;
			case '<':
				++d;
				break;
			case '>':
				if (d == 0) return -1;
				--d;
				++answer;
				break;
			}
		}
        return answer;
    }
}
