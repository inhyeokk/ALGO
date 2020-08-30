package programmers;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/42890
 * @date   2020-03-12
 * @author rkddlsgur983
 */
public class PRO_L2_후보키 {
//	public static void main(String[] args) {
//		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//		System.out.println(solution(relation));
//	}
	private String[][] rela;
	private int len, end, row;
	private boolean[] visit;
	private int cnt;
    private int[] combi;
	private HashSet<String> set;
	public int solution(String[][] relation) {
		rela = relation;
		len = relation[0].length;
		row = relation.length;
		visit = new boolean[1<<len];
		combi = new int[len];
		Arrays.fill(combi, -1);

		// 가능한 후보키 조합을 개수별 부분집합으로 찾음
        for (end = 1; end <= len; ++end) {
        	subset(0, 0, 0);
        }		
		int answer = cnt;
        return answer;
    }
	
	private void subset(int depth, int idx, int cur) {
		
		if (depth == end) {
			set = new HashSet<>();
			// 유일성 검사
			for (int i = 0; i < row; ++i) {
				String s = "";
				for (int j = 0; j < len; ++j) {
					if ((cur & 1<<j)>0) {
						s += rela[i][j];
					}
				}
				if (set.contains(s)) {
					return;
				} else {
					set.add(s);
				}
			}
			// 최소성 검사 - cur이 소속될수 있는 부분집합 제거
			for (int i = cur+1; i < 1<<len; ++i) {
				if (visit[i]) continue;
				int on = 0;
				for (int j = 0; j < len; ++j) {
					if ((cur & 1<<j) > 0 && (i & 1<<j) > 0) {
						if (++on == end) { // 개수가 같으면 cur이 i의 부분집합이므로 더이상 확인하지 않아도 됨
							visit[i] = true;
							break;
						}
					}
				}
			}
			++cnt;
			return;
		}
		
		// 가능한 후보키 조합을 찾음
		for (int i = idx; i < len; ++i) {
			if (!visit[(1 << i)|cur]) {
				combi[depth] = i;
				subset(depth+1, i+1, (1 << i)|cur);
				combi[depth] = -1;
			}
		}
	}
}
