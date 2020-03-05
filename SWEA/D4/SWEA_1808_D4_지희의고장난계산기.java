import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date   2020-03-05
 * @author rkddlsgur983
 * @memory 94632KB / 262144KB
 * @time   181ms / 2초
 */
public class SWEA_1808_D4_지희의고장난계산기 {
	private static boolean[] calc = new boolean[10];
	private static int x, min;
	private static boolean[] visit;
	private static boolean[] dvisit;
	private static List<Pair> list;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 10; ++j) {
				calc[j] = Integer.parseInt(st.nextToken()) == 1;
			}
			x = Integer.parseInt(bf.readLine());
			min = Integer.MAX_VALUE;
			visit = new boolean[x+1];
			dvisit = new boolean[x+1];
			list = new LinkedList<>();
			visit[0] = true; // 0은 추가하지 않음 (0으로 나누지 못함)
			dvisit[x] = true;
			combination(0, 0);
			// 조합에서 찾았다면 최소 버튼으로 찾았으므로 DFS 탐색 하지 않음
			if (min == Integer.MAX_VALUE) {
				dfs(x, 0);
				if (min == Integer.MAX_VALUE) {
					min = -1;
				}
			} else {
				++min; // 계산 버튼
			}
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	// 가능한 숫자 조합이 X의 약수인지 확인하면서 DFS탐색
	private static void dfs(int num, int depth) {
		if (min <= depth) {
			return;
		} else if (num == 1) {
			min = depth;
			return;
		}
		
		for (Pair p: list) {
			if (num % p.num == 0 && !dvisit[num / p.num]) {
				dvisit[num / p.num] = true;
				dfs(num / p.num, depth+p.cnt+1);
				dvisit[num / p.num] = false;
			}
		}
	}
	
	// 계산기의 숫자 버튼으로 만들 수 있는 모든 숫자들을 조합으로 찾음
	private static void combination(int num, int depth) {
		if (x == num) {
			min = depth;
			return;
		}
		
		for (int i = 0; i < 10; ++i) {
			if (calc[i] && num*10+i <= x && !visit[num*10+i]) {
				visit[num*10+i] = true;
				list.add(new Pair(num*10+i, depth+1));
				combination(num*10+i, depth+1);
			}
		}
	}
	
	static class Pair {
		int num;
		int cnt;
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
