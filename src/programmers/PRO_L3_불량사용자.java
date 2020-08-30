package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/64064
 * @date   	2020-05-08
 * @author 	rkddlsgur983
 * @idea	DFS, 비트마스킹
 */
public class PRO_L3_불량사용자 {
	private int u, b;
	private String[] users, banned;
	private final Set<Integer> set = new HashSet<>();
	public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banned = banned_id;
        u = user_id.length;
        b = banned_id.length;
        dfs(0, 0);
		int answer = set.size();
        return answer;
    }
	
	private void dfs(int depth, int check) {
		if (depth == b) {
			set.add(check);
			return;
		}
		for (int i = 0; i < u; ++i) {
			if ((check & (1 << i)) > 0) continue;
			int l1 = banned[depth].length();
			int l2 = users[i].length();
			if (l1 == l2) {
				boolean same = true;
				for (int j = 0; j < l1; ++j) {
					if (banned[depth].charAt(j) == '*') continue;
					if (banned[depth].charAt(j) != users[i].charAt(j)) {
						same = false;
						break;
					}
				}
				if (same) {
					dfs(depth+1, check | 1 << i);
				}
			}
		}
	}
}
