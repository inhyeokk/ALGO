package programmers.line;

public class Solution2 {
	public int solution(String answer_sheet, String[] sheets) {
        int answer = 0, alen = answer_sheet.length();
        for (int i = 0, len = sheets.length; i < len-1; ++i) {
        	for (int j = i+1; j < len; ++j) {
        		int max = 0;
        		int cnt = 0;
        		int total = 0;
        		for (int k = 0; k < alen; ++k) {
        			char ca = answer_sheet.charAt(k);
        			char ci = sheets[i].charAt(k);
        			char cj = sheets[j].charAt(k);
        			if(ci == cj && ca != ci && ca != cj) {
        				++cnt;
        			} else {
        				max = cnt > max ? cnt : max;
        				total += cnt;
        				cnt = 0;
        			}
        		}
        		max = cnt > max ? cnt : max;
				total += cnt;
				int value = total + max*max;
				answer = value > answer ? value : answer;
        	}
        }
        return answer;
    }
}
