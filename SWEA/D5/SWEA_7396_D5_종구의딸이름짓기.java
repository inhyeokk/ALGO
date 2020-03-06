import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 113888KB / 262144KB
 * @time   397ms / 10초
 */
public class SWEA_7396_D5_종구의딸이름짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		char[][] map = new char[2000][2000];
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean[][] visit = new boolean[n][m];
			for (int j = 0; j < n; ++j) {
				String s = bf.readLine();
				for (int k = 0; k < m; ++k) {
					map[j][k] = s.charAt(k);
				}
			}
			
			char[] ans = new char[n+m-1]; // 답을 저장하기 위한 배열
			PriorityQueue<Move> pq = new PriorityQueue<>();
			List<Move> list = new LinkedList<>();
			visit[0][0] = true;
			pq.add(new Move(0,0,map[0][0]));
			int step = 0;
			while (!pq.isEmpty()) {
				ans[step++] = pq.peek().a;
				/* 좌측 상단부터 우측하단까지 
				 * 오른쪽 or 아래쪽으로만 탐색하므로
				 * step의 길이는 n+m-1로 일정함
				 */
				if (step == n+m-1) {
					break;
				}
				/* 사전 순으로 가장 앞선 값(우선순위 큐에서 나온 값)들의
				 * 주변 좌표들을 임시 list에 저장
				 */
				for (int j = 0, size = pq.size(); j < size; ++j) {
					if (pq.peek().a != ans[step-1]) break;
					Move mo = pq.poll();
					int row = mo.r;
					int col = mo.c;
					if (row+1 < n && !visit[row+1][col]) {
						visit[row+1][col] = true;
						list.add(new Move(row+1,col,map[row+1][col]));
					} 
					if (col+1 < m && !visit[row][col+1]) {
						visit[row][col+1] = true;
						list.add(new Move(row,col+1,map[row][col+1]));
					}
				}
				pq.clear();
				pq.addAll(list);
				list.clear();
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Move implements Comparable<Move> {
		int r;
		int c;
		char a;
		
		public Move(int r, int c, char a) {
			this.r = r;
			this.c = c;
			this.a = a;
		}
		
		@Override
		public int compareTo(Move o) {
			if (a < o.a) {
				return -1;
			} else if (a == o.a) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
