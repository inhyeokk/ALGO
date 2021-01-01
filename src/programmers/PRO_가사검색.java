package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link}  https://programmers.co.kr/learn/courses/30/lessons/60060
 * @date    2021-01-01
 * @author  rkddlsgur983
 * @comment 효율성 2번 시간초과
 */
public class PRO_가사검색 {
    public int[] solution(String[] words, String[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String query = queries[i];
            if (map.containsKey(query)) {
                answer[i] = map.get(query);
            } else {
                int len = query.length();
                int cnt = 0;
                for (String word: words) {
                    if (len == word.length()) {
                        boolean ok = true;
                        for (int j = 0; j < len; ++j) {
                            if (query.charAt(j) != word.charAt(j)
                                    && query.charAt(j) != '?') {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) ++cnt;
                    }
                }
                answer[i] = cnt;
                map.put(query, cnt);
            }
        }
        return answer;
    }
}
