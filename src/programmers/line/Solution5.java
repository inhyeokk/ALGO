package programmers.line;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution5 {
	public String[] solution(String[][] dataSource, String[] tags) {
        Set<String> set = new HashSet<>();
    	for (int i = 0, len = tags.length; i < len; ++i) {
    		set.add(tags[i]);
    	}
    	List<String[]> list = new LinkedList<>();
    	for (String[] data: dataSource) {
    		int cnt = 0;
    		for (int i = 1, len = data.length; i < len; ++i) {
    			if (set.contains(data[i])) {
    				++cnt;
    			}
    		}
    		if (cnt > 0) {
    			String[] input = { data[0], String.valueOf(cnt) };
    			list.add(input);
    		}
    	}
    	Collections.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
	            return o2[1].compareTo(o1[1]);
			}
		});
    	String[] answer = new String[list.size()];
    	int i = 0;
    	for (String[] t: list) {
    		answer[i++] = t[0];
    	}
    	return answer;
    }
}
