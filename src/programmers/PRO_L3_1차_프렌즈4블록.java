package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/17679
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 */
public class PRO_L3_1차_프렌즈4블록 {
	private final int[][] di = {{0,1},{1,0},{1,1}};
	public int solution(int m, int n, String[] board) {
		char[][] map = new char[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				map[i][j] = board[i].charAt(j);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int answer = 0;
		while (true) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (map[i][j] == ' ') continue;
					int cnt = 0;
					for (int[] d: di) {
						int nr = i + d[0];
						int nc = j + d[1];
						if (nr >= 0 && nr < m && nc >= 0 && nc < n 
								&& map[i][j] == map[nr][nc]) {
							++cnt;
						}
					}
					if (cnt == 3) {
						q.add(new int[] {i,j});
						for (int[] d: di) {
							int nr = i + d[0];
							int nc = j + d[1];
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			if (q.isEmpty()) break;
			while (!q.isEmpty()) {
				int[] i = q.poll();
				if (map[i[0]][i[1]] != ' ') {
					++answer;
					map[i[0]][i[1]] = ' ';
				}
			}
			for (int i = m-3; i >= 0; --i) {
				for (int j = 0; j < n; ++j) {
					if (map[i][j] != ' ') {
						int nr = i+1;
						while (nr < m && map[nr][j] == ' ') {
							++nr;
						}
						if (nr-1 < m && map[nr-1][j] == ' ') {
							char tmp = map[i][j];
							map[i][j] = ' ';
							map[nr-1][j] = tmp;
						}
					}
				}
			}
		}
		return answer;
	}
}
