package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory 35436KB / 262144KB
 * @time   106ms / 2초
 */
public class SWEA_D3_2814_최장경로_비트마스킹 {
	private static int n;
	private static int[][] memo; // 어떤 방문상태로 어떤 정점에 도달했는지
	private static boolean[][] graph;
	private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            st = new StringTokenizer(bf.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new boolean[n][n];
            memo = new int[1<<n][n];
            for (int j = 0; j < m; j++) {
            	st = new StringTokenizer(bf.readLine(), " ");
            	int x = Integer.parseInt(st.nextToken())-1;
            	int y = Integer.parseInt(st.nextToken())-1;
            	graph[x][y] = true;
            	graph[y][x] = true;
            }
            
            max = 0;
            for (int j = 0; j < n; j++) {
            	max = Math.max(dfs(j, 1<<j), max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
        bf.close();
    }
    
    private static int dfs(int start, int visit) {
    	// 이전에 방문했던 상태로 같은 정점을 방문했다면 종료
    	if (memo[visit][start] != 0)
    		return memo[visit][start];
    	
    	// 더이상 방문할 노드가 없으면 현재 방문하는 노드 1개만이 남은 경로이므로, 초기값 1
    	int ret = 1;
    	// 모든 노드를 검사하며, 방문안한 노드가 있다면 재귀호출하고, 호출한 노드가 가지는 최장경로 값+1중 최대값을 기억
    	for (int i = 0; i < n; i++) {
    		if (graph[start][i] && (visit & 1<<i) == 0) {
    			ret = Math.max(dfs(i, visit | 1<<i)+1, ret);
    		}
    	}
    	
    	// 계산된 현재상태의 남은 최장 경로 값을 기억
    	memo[visit][start] = ret;
    	return ret;
    }
}