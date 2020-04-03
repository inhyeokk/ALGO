import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/42895
 * @date   	2020-04-03
 * @author 	rkddlsgur983
 * @idea	BFS
 */
public class PRO_L3_가장먼노드 {
	public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
        	graph[i] = new LinkedList<>();
        }
        for (int i = 0, len = edge.length; i < len; ++i) {
        	int a = edge[i][0]-1;
        	int b = edge[i][1]-1;
        	graph[a].add(b);
        	graph[b].add(a);
        }
        boolean[] visit = new boolean[n];
        visit[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int answer = 0;
        while (!queue.isEmpty()) {
        	answer = 0;
        	for (int i = 0, size = queue.size(); i < size; ++i) {
        		int j = queue.poll();
				++answer;
        		for (Integer k: graph[j]) {
        			if (!visit[k]) {
        				visit[k] = true;
        				queue.add(k);
        			}
        		}
        	}
        }
        return answer;
    }
}
