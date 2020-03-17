import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/13913
 * @date   	2020-03-17
 * @author 	rkddlsgur983
 * @memory 	33384KB / 512MB
 * @time   	260ms / 2초
 * @idea	1. BFS 탐색 시 매 step만큼 이동하면서 이동 위치에 현재 step을 메모
 * 			2. K위치에 도달하면 기록된 step을 거꾸로 밟아가면서 스택에 푸시
 * 			3. N위치로 돌아오면 스택 내의 이동 기록을 출력
 */
public class BOJ_13913_G4_숨바꼭질4 {
	private static int N = 100001;
	private static boolean[] visit = new boolean[N];
	private static int[] memo = new int[N];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		bf.close();
		StringBuilder sb = new StringBuilder();
		if (n == k) {
			sb.append(0).append("\n").append(n);
			System.out.print(sb);
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visit[n] = true;
		int step = 1;
		memo[n] = step;
		here:
		while (!queue.isEmpty()) {
			++step;
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int j = queue.poll();
				int next = j*2;
				if (next < N && !visit[next] && memo[next] == 0) {
					if (next == k) {
						break here;
					}
					visit[next] = true;
					memo[next] = step;
					queue.add(next);
				}
				next = j+1;
				if (next < N && !visit[next] && memo[next] == 0) {
					if (next == k) {
						break here;
					}
					visit[next] = true;
					memo[next] = step;
					queue.add(next);
				}
				next = j-1;
				if (next >= 0 && !visit[next] && memo[next] == 0) {
					if (next == k) {
						break here;
					}
					visit[next] = true;
					memo[next] = step;
					queue.add(next);
				}
			}
		}
		
		--step;
		sb.append(step).append("\n");
		Stack<Integer> s = new Stack<>();
		s.add(k);
		while (step >= 1) {
			if (k+1 < N && memo[k+1] == step) {
				++k;
			} else if (k-1 >= 0 && memo[k-1] == step) {
				--k;
			} else {
				k /= 2;
			}
			s.add(k);
			--step;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}
		System.out.print(sb);
	}
}
