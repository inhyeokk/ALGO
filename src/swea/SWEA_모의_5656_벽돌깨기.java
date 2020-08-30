package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-09
 * @author rkddlsgur983
 * @memory 60364KB / 256MB
 * @time   193ms / 3초
 */
public class SWEA_모의_5656_벽돌깨기 {
	private static int n, w, h;
	private static int[][] map;
	private static int min;
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static final Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			int brick = 0;
			for (int j = 0; j < h; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int k = 0; k < w; ++k) {
					map[j][k] = Integer.parseInt(st.nextToken());
					if (map[j][k] > 0) {
						++brick;
					}
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0, brick);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int depth, int brick) {
		
		if (depth == n) {
			min = min > brick ? brick : min;
			return;
		} else if (min == 0) {
			return;
		}
		
		int[][] tmap = new int[h][w];
		for (int i = 0; i < h; ++i) {
			tmap[i] = map[i].clone();
		}
		
		// 구슬이 발사되는 위치를 잡음
		for (int i = 0; i < w; ++i) {
			if (min == 0) return;
			int shot = 0;
			for (int j = 0; j < h; ++j) {
				// 벽돌을 만났을 때
				if (map[j][i] >= 1) {
					// 주변 벽돌 깨짐
					if (map[j][i] > 1) {
						queue.add(new int[] {j,i,map[j][i]});
					}
					++shot;
					map[j][i] = 0;
					break;
				}
			}
			
			// 벽돌 깨기
			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int row = tmp[0];
				int col = tmp[1];
				int ran = tmp[2];
				for (int[] d: di) {
					for (int k = 1; k < ran; ++k) {
						int nr = row + d[0]*k;
						int nc = col + d[1]*k;
						if (isInRange(nr,nc) && map[nr][nc] >= 1) {
							if (map[nr][nc] > 1) {
								queue.add(new int[] {nr,nc,map[nr][nc]});
							}
							++shot;
							map[nr][nc] = 0;
						}
					}
				}
			}
			
			/* 벽돌 내림
			 * 0 or 1개 깨졌을 때 내리지 않아도 됨
			 */
			if (shot >= 2) {
				for (int j = 0; j < w; ++j) {
					for (int k = h-1, bcnt = h-1; k >= 0; --k) {
						if (map[k][j] > 0) {
							int tmp = map[k][j];
							map[k][j] = 0;
							map[bcnt--][j] = tmp;
						}
					}
				}
			}
			dfs(depth+1, brick-shot);
			for (int j = 0; j < h; ++j) {
				map[j] = tmap[j].clone();
			}
		}
	}
	
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
