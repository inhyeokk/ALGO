package programmers.line;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	public int solution(String road, int n) {
		List<Integer> alist = new ArrayList<>();
		List<Integer> blist = new ArrayList<>();
		boolean damaged = false;
		int cnt = 0;
		for (int i = 0, len = road.length(); i < len; ++i) {
			char r = road.charAt(i);
			if (!damaged) {
				if (r == '1') {
					++cnt;
				} else {
					damaged = true;
					alist.add(cnt);
					cnt = 0;
					++cnt;
				}
			} else {
				if (r == '1') {
					damaged = false;
					blist.add(cnt);
					cnt = 0;
					++cnt;
				} else {
					++cnt;
				}
			}
		}
		if (!damaged) {
			alist.add(cnt);
		} else {
			blist.add(cnt);
		}
        int answer = -1;
        int asize = alist.size(), bsize = blist.size();
        for (int i = 0, size = alist.size(); i < size; ++i) {
        	int total = 0, sum = 0;
        	for (int j = i; j < size; ++j) {
        		total += alist.get(j);
        		if (asize > bsize && j == size-1) continue;
        		if (sum + blist.get(j) <= n) {
        			sum += blist.get(j);
        		} else {
        			break;
        		}
        	}
        	total += sum;
        	answer = total > answer ? total : answer;
        }
        return answer;
    }
}
