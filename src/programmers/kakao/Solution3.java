package programmers.kakao;
import java.util.Arrays;
import java.util.HashSet;

public class Solution3 {
	private int ulen, blen;
	private final HashSet<String> set = new HashSet<>();
	private boolean[] visit;
	
	public int solution(String[] user_id, String[] banned_id) {
        ulen = user_id.length;
        blen = banned_id.length;
        visit = new boolean[ulen];
        dfs(0, user_id, banned_id, new String[blen]);
        return set.size();
    }
	
	private void dfs(int k, String[] user_id, String[] banned_id, String[] s) {
		if (k == blen) {
			String[] tmp = new String[blen];
			tmp = s.clone();
			Arrays.sort(tmp);
			String str = "";
			for (String t: tmp) {
				str += ","+t;
			}
			set.add(str);
			return;
		}
		
		for (int j = 0; j < ulen; ++j) {
			if (visit[j]) continue;
			visit[j] = true;
    		String s1 = user_id[j];
    		String s2 = banned_id[k];
    		int l1 = s1.length();
    		int l2 = s2.length();
    		if (l1 == l2) {
        		boolean possible = true;
    			for (int l = 0; l < l1; ++l) {
    				if (s2.charAt(l) == '*') continue;
    				if (s1.charAt(l) != s2.charAt(l)) {
    					possible = false;
    					break;
    				}
    			}
    			if (possible) {
    				s[k] = s1;
    				dfs(k+1, user_id, banned_id, s);
    				s[k] = "";
    				dfs(k, user_id, banned_id, s);
    			}
    		}
    		visit[j] = false;
    	}
	}
}
