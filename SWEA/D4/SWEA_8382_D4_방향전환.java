import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory 108936KB / 262144KB
 * @time   466ms / 2초
 */
public class SWEA_8382_D4_방향전환 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean[][][] graph = new boolean[201][201][2];
		Queue<Integer> queue = new LinkedList<>();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken())+100;
			int y1 = Integer.parseInt(st.nextToken())+100;
			int x2 = Integer.parseInt(st.nextToken())+100;
			int y2 = Integer.parseInt(st.nextToken())+100;
			for (int j = 0; j < 201; ++j) {
				for (int k = 0; k < 201; ++k) {
					graph[j][k][0] = false;
					graph[j][k][1] = false;
				}
			}
			graph[x1][y1][0] = true;
			graph[x1][y1][1] = true;
			queue.add(x1);
			queue.add(y1);
			queue.add(-1); // 0: 가로, 1: 세로
			for (int step = 0; !queue.isEmpty(); ++step) {
				for (int j = 0, size = queue.size(); j < size; j+=3) {
					int x = queue.poll();
					int y = queue.poll();
					int k = queue.poll();
					
					if (x == x2 && y == y2) {
						sb.append("#").append(i).append(" ").append(step).append("\n");
						queue.clear();
						break;
					}
					
					if (k == 0 || k == -1) {
						if (isInRange(x, y+1) && !graph[x][y+1][0]) {
							graph[x][y+1][0] = true;
							queue.add(x);
							queue.add(y+1);
							queue.add(1);
						}
						if (isInRange(x, y-1) && !graph[x][y-1][0]) {
							graph[x][y-1][0] = true;
							queue.add(x);
							queue.add(y-1);
							queue.add(1);
						}
					}
					if (k == 1 || k == -1) {
						if (isInRange(x+1, y) && !graph[x+1][y][1]) {
							graph[x+1][y][1] = true;
							queue.add(x+1);
							queue.add(y);
							queue.add(0);
						}
						if (isInRange(x-1, y) && !graph[x-1][y][1]) {
							graph[x-1][y][1] = true;
							queue.add(x-1);
							queue.add(y);
							queue.add(0);
						}
					}
				}
			}
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < 201 && col >= 0 && col < 201;
	}
}
