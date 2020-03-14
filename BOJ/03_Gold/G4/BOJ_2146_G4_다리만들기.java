import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link} https://www.acmicpc.net/problem/2023
 * @date   2020-03-14
 * @author rkddlsgur983
 * @memory 107000KB / 4MB
 * @time   404ms / 2초
 * @idea	1. 각 대륙을 돌면서 바다와 접하고 있는 좌표 리스트를 저장
 * 			   대륙 간 거리를 좌표 간의 절댓값으로 구함 => 시간초과
 * 			2. DFS, BFS 모두 시간초과
 * 			3. 1번 아이디어는 맞지만 연결리스트에서 인덱싱시 시간초과
 * 			   ArrayList로 변경 => 정답 / 빈번한 인덱싱시 주의할 것
 */
public class BOJ_2146_G4_다리만들기 {
	private static int n;
	private static int[][] map;
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 2;
		Queue<int[]> queue = new LinkedList<>();
		List<List<int[]>> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j] == 1) {
					map[i][j] = num;
					queue.add(new int[] {i,j});
					List<int[]> l = new ArrayList<>();
					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();
						int r = tmp[0];
						int c = tmp[1];
						int open = 0;
						for (int[] d: di) {
							int nr = r + d[0];
							int nc = c + d[1];
							if (nr >= 0 && nr < n && nc >= 0&& nc < n) {
								if (map[nr][nc] == 1) {
									map[nr][nc] = num;
									queue.add(new int[] {nr,nc});
								}
								if (map[nr][nc] > 1) {
									++open;
								}
							}
						}
						if (open < 4) {
							l.add(tmp);
						}
					}
					list.add(l); // 각 대륙의 가장자리 지역
					++num;
				}
			}
		}
		
		int size = list.size(); // 대륙 개수
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size-1; ++i) {
			List<int[]> al = list.get(i);
			for (int j = i+1; j < size; ++j) {
				List<int[]> bl = list.get(j);
				for (int[] a: al) {
					int ar = a[0];
					int ac = a[1]; 
					for (int[] b: bl) {
						int br = b[0];
						int bc = b[1];
						min = Math.min(Math.abs(ar-br)+Math.abs(ac-bc), min);
					}
				}
			}
		}
		System.out.print(min-1);
		bf.close();
	}
}
