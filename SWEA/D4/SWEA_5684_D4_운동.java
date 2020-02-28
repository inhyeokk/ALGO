import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @date   2020-02-28
 * @author rkddlsgur983
 * @memory 78164KB
 * @time   1437ms
 */
public class SWEA_5684_D4_운동 {
	private static List<Integer>[] graph;
    private static boolean[] visit = new boolean[401];
    private static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            graph = new LinkedList[n+1];
            for (int j = 1; j <= n; ++j) {
                graph[j] = new LinkedList<>();
            }
            for (int j = 0; j < m; ++j) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int c = sc.nextInt();
                graph[s].add(e); // 도착점
                graph[s].add(c); // 길이
            }
             
            min = Integer.MAX_VALUE;
            for (int j = 1; j <= n; ++j) {
                int size = graph[j].size();
                if (size == 0) continue;
                // 시작점까지 돌아와야 하므로 방문 표시X
                for (int k = 0; k < size; k+=2) {
                    int e = graph[j].get(k);
                    int c = graph[j].get(k+1);
                    if (min > c) {
                        dfs(j, e, c);
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
     
    private static void dfs(int start, int current, int length) {
         
        if (start == current) {
            min = min > length ? length : min;
            return;
        }
         
        for (int i = 0, size = graph[current].size(); i < size; i+=2) {
            int e = graph[current].get(i);
            int c = graph[current].get(i+1);
            if (!visit[e] && min > length + c) {
                visit[e] = true;
                dfs(start, e, length+c);
                visit[e] = false;
            }
        }
    }
}
