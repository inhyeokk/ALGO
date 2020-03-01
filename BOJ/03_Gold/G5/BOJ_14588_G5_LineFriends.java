import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-01
 * @author rkddlsgur983
 * @memory 24160KB
 * @time   628ms
 */
public class BOJ_14588_G5_LineFriends {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int[][] loc = new int[n+1][2];
		loc[0][0] = Integer.MIN_VALUE;
		loc[1][0] = Integer.MIN_VALUE;
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			loc[i][0] = l;
			loc[i][1] = r;
		}
		
		// 친구 관계 그래프를 연결리스트 배열로 생성하고 양방향 추가
		List<Integer>[] graph = new LinkedList[n+1];
		int[][] friend = new int[n+1][n+1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
			Arrays.fill(friend[i], -1);
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j) continue;
				if (loc[i][1] < loc[j][0]) continue;
				if (loc[i][0] > loc[j][1]) continue;
				graph[i].add(j);
				graph[j].add(i);
			}
		}
		
		// i와 1~n까지 친구가 얼마나 가까운지 확인
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; ++i) {
			queue.add(i);
			for (int step = 1; !queue.isEmpty(); ++step) {
				for (int k = 0, size = queue.size(); k < size; ++k) {
					int me = queue.poll();
					for (Integer f: graph[me]) {
						if (i != f && friend[i][f] == -1) {
							friend[i][f] = step;
							friend[f][i] = step;
							queue.add(f);
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(bf.readLine());
		for (int i = 0; i < q; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(friend[a][b]).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
