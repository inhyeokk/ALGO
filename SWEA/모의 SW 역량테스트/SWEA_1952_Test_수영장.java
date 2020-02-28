import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-02-28
 * @author rkddlsgur983
 * @memory 23848KB
 * @time   116ms
 */
public class SWEA_1952_Test_수영장 {
	private static int[] charge = new int[4];
	private static int[] plan = new int[12];
	private static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 4; ++j) {
				charge[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < 12; ++j) {
				plan[j] = Integer.parseInt(st.nextToken());
			}
			min = charge[3];
			search(0, 0);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void search(int idx, int cost) {
		
		if (idx >= 12) {
			min = min > cost ? cost : min;
			return;
		}
		
		search(idx+1, cost+charge[0]*plan[idx]);
		search(idx+1, cost+charge[1]);
		search(idx+3, cost+charge[2]);
	}
}
