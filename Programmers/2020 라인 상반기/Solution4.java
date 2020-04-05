import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Solution4 {
	public String[][] solution(String[][] snapshots, String[][] transactions) {
        Set<Integer> set = new HashSet<>();
		TreeMap<String, Integer> map = new TreeMap<>();
        for (String[] s: snapshots) {
        	map.put(s[0], Integer.parseInt(s[1]));
        }
        for (String[] t: transactions) {
        	if (set.contains(Integer.parseInt(t[0]))) continue;
    		set.add(Integer.parseInt(t[0]));
        	if (t[1].equals("SAVE")) {
        		if (map.containsKey(t[2])) {
    				map.put(t[2], map.get(t[2])+Integer.parseInt(t[3]));
    			} else {
    				map.put(t[2], Integer.parseInt(t[3]));
    			}
        	} else {
        		if (map.containsKey(t[2])) {
    				map.put(t[2], map.get(t[2])-Integer.parseInt(t[3]));
    			} else {
    				map.put(t[2], 0-Integer.parseInt(t[3]));
    			}
        	}
        }
		String[][] answer = new String[map.size()][2];
		int i = 0;
		for (String s: map.keySet()) {
			answer[i][0] = s;
			answer[i++][1] = String.valueOf(map.get(s));
		}
        return answer;
    }
}
