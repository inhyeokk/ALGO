package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-02-29
 * @author rkddlsgur983
 * @memory 26908KB
 * @time   108ms
 */
public class SWEA_D4_7208_지도칠하기 {
	private static int[][] graph;
    private static int[] color;
    private static int n;
    private static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        graph = new int[8][8];
        color = new int[8];
        for (int i = 1; i <= t; ++i) {
            n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; ++j) {
                color[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(bf.readLine(), " ");
                for (int k = 0; k < n; ++k) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
        bf.close();
    }
     
    private static void dfs(int idx, int change) {
        if (idx == n) {
        	for (int i = 0; i < n; ++i) {
        		for (int j = 0; j < n; ++j) {
        			// i와 j가 인접하면서 색이 같으면 불가능
        			if (graph[i][j] == 1 && color[i] == color[j]) {
        				return;
        			}
        		}
        	}
            min = min > change ? change : min;
            return;
        } else if (min <= change) {
            return;
        }
        
        // 색 변경하면서 DFS
        for (int i = 1; i <= 4; ++i) {
        	if (color[idx] == i) {
        		dfs(idx+1, change);
        	} else {
            	int tmp = color[idx];
            	color[idx] = i;
            	dfs(idx+1, change+1);
            	color[idx] = tmp;
        	}
        }
    }
}
