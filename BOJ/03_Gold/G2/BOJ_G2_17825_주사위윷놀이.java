import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/17825
 * @date   	2020-03-26
 * @author 	rkddlsgur983
 * @memory 	17212KB / 512MB
 * @time   	152ms / 2초
 * @idea	말 이동 시 방문체크 주의
 */
public class BOJ_G2_17825_주사위윷놀이 {
	/* N: 주사위를 던지는 횟수
	 * M: 말의 수
	 * max: 얻을 수 있는 점수의 최댓값
	 * map: 말이 이동하는 말판
	 * visit: 말이 말판 위에 있는 위치
	 * roll: 주사위를 던져서 나올 수
	 * len: 각 말판의 길이
	 * targets: 말의 정보
	 */
	private static int N = 10, M = 4, max = 0;
	private static int[][] map = {
			{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
			{10,13,16,19,25,30,35,40},
			{20,22,24,25,30,35,40},
			{30,28,27,26,25,30,35,40}
	};
	private static boolean[][] visit = new boolean[M][];
	private static int[] roll = new int[N];
	private static int[] len = new int[M];
	private static Target[] targets = new Target[M];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			roll[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		for (int i = 0; i < M; ++i) {
			targets[i] = new Target(0, 0, false);
			len[i] = map[i].length;
			visit[i] = new boolean[len[i]];
		}
		dfs(0, 0);
		System.out.print(max);
	}
	
	private static void dfs(int depth, int score) {
		if (depth == N) {
			max = Math.max(score, max);
			return;
		}
		
		for (int j = 0; j < M; ++j) {
			if (targets[j].out) continue; // 이동을 마친 말
			int i = targets[j].i;
			int d = targets[j].d;
			visit[d][i] = false; // 이동하기 위해 이전 위치 false
			if (i+roll[depth] < len[d] && !visit[d][i+roll[depth]]) {
				int c = map[d][i+roll[depth]];
				if (d == 0) {
					if (c == 10 || c == 20 || c == 30) {
						int k = c / 10;
						if (!visit[k][0]) {
							visit[k][0] = true;
							targets[j].d = k;
							targets[j].i = 0;
							dfs(depth+1, score+c);
							targets[j].i = i;
							targets[j].d = 0;
							visit[k][0] = false;
						}
					} else {
						visit[d][i+roll[depth]] = true;
						targets[j].i += roll[depth];
						dfs(depth+1, score+map[d][targets[j].i]);
						targets[j].i -= roll[depth];
						visit[d][i+roll[depth]] = false;
					}
				} else if (d == 1 || d == 2 || d == 3) { 
					if (c == 25) {
						if (!visit[1][4] && !visit[2][3] && !visit[3][4]) {
							visit[d][i+roll[depth]] = true;
							targets[j].i += roll[depth];
							dfs(depth+1, score+map[d][targets[j].i]);
							targets[j].i -= roll[depth];
							visit[d][i+roll[depth]] = false;
						}
					} else if (c == 30) {
						if (!visit[1][5] && !visit[2][4] && !visit[3][5]) {
							visit[d][i+roll[depth]] = true;
							targets[j].i += roll[depth];
							dfs(depth+1, score+map[d][targets[j].i]);
							targets[j].i -= roll[depth];
							visit[d][i+roll[depth]] = false;
						}
					} else if (c == 35) {
						if (!visit[1][6] && !visit[2][5] && !visit[3][6]) {
							visit[d][i+roll[depth]] = true;
							targets[j].i += roll[depth];
							dfs(depth+1, score+map[d][targets[j].i]);
							targets[j].i -= roll[depth];
							visit[d][i+roll[depth]] = false;
						}
					} else if (c == 40) {
						if (!visit[0][20] && !visit[1][7] && !visit[2][6] && !visit[3][7]) {
							visit[0][20] = true;
							targets[j].d = 0;
							targets[j].i = 20;
							dfs(depth+1, score+c);
							targets[j].i = i;
							targets[j].d = d;
							visit[0][20] = false;
						}
					} else {
						visit[d][i+roll[depth]] = true;
						targets[j].i += roll[depth];
						dfs(depth+1, score+map[d][targets[j].i]);
						targets[j].i -= roll[depth];
						visit[d][i+roll[depth]] = false;
					}
				} 
			} else if (i+roll[depth] >= len[d]) { 
				targets[j].out = true;
				dfs(depth+1, score);
				targets[j].out = false;
			}
			visit[d][i] = true;
		} 
	}
	
	static class Target {
		int i; // 위치
		int d; // 방향
		boolean out;
		
		public Target(int i, int d, boolean out) {
			this.i = i;
			this.d = d;
			this.out = out;
		}
	}
}
