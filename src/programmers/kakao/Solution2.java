package programmers.kakao;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
	public int[] solution(String s) {
		List<List<Integer>> list = new LinkedList<>();
		for (int i = 1, len = s.length()-1; i < len; ++i) {
			if (s.charAt(i) == '{') {
				++i;
				int si = i;
				List<Integer> l = new LinkedList<>();
				while (!(s.charAt(i) == '}')) {
					si = i;
					while (!(s.charAt(i) == ',') && !(s.charAt(i) == '}')) {
						++i;
					}
					l.add(Integer.parseInt(s.substring(si, i)));
					if (s.charAt(i) == ',') {
						++i;
					}
				}
				list.add(l);
			}
		}
		Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				int s1 = o1.size();
				int s2 = o2.size();
				return Integer.compare(s1, s2);
			}
		});
        int[] answer = new int[list.size()];
        for (int i = 0, len = answer.length; i < len; ++i) {
        	answer[i] = list.get(i).get(0);
        	for (int j = i+1; j < len; ++j) {
        		list.get(j).remove(Integer.valueOf(answer[i]));
        	}
        }
        return answer;
    }
}
