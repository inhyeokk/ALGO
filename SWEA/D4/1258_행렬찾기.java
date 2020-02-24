import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_1258_행렬찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int x1 = o1[0]*o1[1];
				int x2 = o2[0]*o2[1];
				if (x1 == x2) {
					if (o1[0] < o2[0])
						return -1;
					else if (o1[0] == o2[0])
						return 0;
					else return 1;
				} else {
					if (x1 < x2) return -1;
					else return 1;
				}
			}
		});
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			int[][] map = new int[n][n];
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					if (map[j][k] > 0) {
						int nr = j+1;
						int nc = k+1;
						map[j][k] = 0;
						while (nc < n-1 && map[j][nc] > 0) {
							map[j][nc] = 0;
							++nc;
						}
						while (nr < n-1 && map[nr][k] > 0) {
							for (int l = k; l < nc; ++l) {
								map[nr][l] = 0;
							}
							++nr;
						}
						int[] tmp = {nr-j, nc-k};
						pq.add(tmp);
					}
				}
			}
			sb.append("#").append(i).append(" ").append(pq.size()).append(" ");
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				sb.append(tmp[0]).append(" ").append(tmp[1]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
