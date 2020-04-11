import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/13325
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	171912KB / 512MB
 * @time   	480ms / 1초
 * @idea	이진트리 재귀 연산
 */
public class BOJ_G4_13325_이진트리 {
	private static int k, sum = 0;
	private static int[] weight;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int n = (int)Math.pow(2, k+1)-1;
		weight = new int[n];
		for (int i = 1; i < n; ++i) {
			weight[i] = Integer.parseInt(st.nextToken());
			sum += weight[i];
		}
		dfs(0, 0);
		System.out.println(sum);
	}
	
	private static int dfs(int depth, int cur) {
		if (depth == k+1) {
			return 0;
		}
		
		int a = dfs(depth+1, cur*2+1);
		int b = dfs(depth+1, cur*2+2);
		sum += Math.abs(a-b);
		return weight[cur] + Math.max(a, b);
	}
}
