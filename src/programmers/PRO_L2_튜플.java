package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/64065
 * @date   	2020-05-08
 * @author 	rkddlsgur983
 * @idea	문자열 분리
 */
public class PRO_L2_튜플 {
	public int[] solution(String s) {
		StringTokenizer st = new StringTokenizer(s, "{}");
		List<List<Integer>> list = new LinkedList<>();
		while (st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
			List<Integer> l = new ArrayList<>();
			while (st2.hasMoreTokens()) {
				l.add(Integer.parseInt(st2.nextToken()));
			}
			if (!l.isEmpty()) {
				list.add(l);
			}
		}
		Collections.sort(list, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				int l1 = o1.size();
				int l2 = o2.size();
				return Integer.compare(l1, l2);
			}
		});
        int len = list.size();
		int[] answer = new int [len];
        for (int i = 0; i < len; ++i) {
        	answer[i] = list.get(0).get(0);
        	list.remove(0);
        	for (int j = 0, size = list.size(); j < size; ++j) {
        		list.get(j).remove(Integer.valueOf(answer[i]));
        	}
        }
        return answer;
    }
}
