package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date   2020-03-14
 * @author rkddlsgur983
 * @memory 48548KB / 256MB
 * @time   222ms / 2초
 */
public class SWEA_D4_1868_파핑파핑지뢰찾기 {
	private static int n;
	private static char[][] map;
	private static Node[][] nmap;
	private static final int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			n = Integer.parseInt(bf.readLine());
			map = new char[n][n];
			nmap = new Node[n][n];
			for (int j = 0; j < n; ++j) {
				map[j] = bf.readLine().toCharArray();
			}
			
			List<Node> list = new LinkedList<>();
			int move = 0;
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					if (map[j][k] == '*') continue;
					boolean zero = true;
					for (int[] d: di) {
						int nr = j + d[0];
						int nc = k + d[1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '*') {
							zero = false;
							break;
						}
					}
					if (zero) { // 8방향 모두 지뢰가 아닌경우
						nmap[j][k] = new Node(j,k);
						list.add(nmap[j][k]);
					} else {
						++move; // 주변에 지뢰가 있는 경우 개수를 셈
					}
				}
			}
			
			int cnt = 0;
			Queue<Node> queue = new LinkedList<>();
			while (!list.isEmpty()) {
				Node node = list.remove(0);
				map[node.r][node.c] = 'c';
				queue.add(node);
				++cnt; // 클릭 횟수
				while (!queue.isEmpty()) {
					node = queue.poll();
					int r = node.r;
					int c = node.c;
					for (int[] d: di) {
						int nr = r + d[0];
						int nc = c + d[1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '.') {
							map[nr][nc] = 'c';
							if (nmap[nr][nc] != null) { // 주변을 연속해서 탐색할 수 있는 경우
								Node tmp = nmap[nr][nc];
								list.remove(tmp); // 중복 탐색 방지를 위해 제거
								queue.add(tmp); // 연속 탐색
							} else {
								--move; // 이미 셌음
							}
						}
					}
				}
			}
			cnt += move;  // 주변에 지뢰가 없는 지점들을 전부 클릭해주었으므로 이후부터는 1번씩 모두 클릭해야함
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
