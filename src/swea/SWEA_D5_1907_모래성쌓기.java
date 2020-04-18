package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-03
 * @author rkddlsgur983
 * @memory 110928KB / 262144KB
 * @time   577ms / 2초
 */
public class SWEA_D5_1907_모래성쌓기 {
	private static int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			for (int j = 0; j < h; ++j) {
				String s = bf.readLine();
				for (int k = 0; k < w; ++k) {
					char c = s.charAt(k);
					if (c == '.') {
						map[j][k] = 0;
						queue.add(j);
						queue.add(k);
					} else {
						map[j][k] = c - '0';
					}
				}
			}
			
			/* 1. 2차원 map을 탐색하면서 모래가 없어질 수 있는 경우 하나하나 찾음, 
			 *    임시배열에 복사 -> 시간초과
			 * 2. 1과 동일하게 찾음, 큐에 바뀌는 좌표만 저장하고 탐색이 끝나면 저장된 좌표의 map 변경
			 * 	  -> 시간초과
			 * 3. 모래의 좌표를 입력받으면서 큐에 저장 9는 제외, 
			 *    큐 돌면서 각 좌표의 8방향을 탐색하고 없어지는 경우 임시 큐, 
			 *    유지되는 경우 큐에 다시 추가 -> 런타임 에러 
			 * 4. 모래가 아닌 좌표를 큐에 저장, 큐 돌면서 8방향 탐색하고 주변 모래를 1씩 깎음,
			 *    0이 될 경우 모래가 사라졌으므로 큐에 추가, 큐가 비었을 때 더이상 모래가 사라지지 않으므로 종료
			 *    -> 성공
			 */
			int cnt = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for (int j = 0; j < size; j+=2) {
					int row = queue.poll();
					int col = queue.poll();
					for (int d = 0; d < di.length; ++d) {
						int nr = row + di[d][0];
						int nc = col + di[d][1];
						if (isInRange(nr,nc,h,w) && map[nr][nc] > 0) {
							--map[nr][nc];
							if (map[nr][nc] == 0) {
								queue.add(nr);
								queue.add(nc);
							}
						}
					}
				}
				if (!queue.isEmpty())
					++cnt;
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int h, int w) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
