package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12978
 * @date   	2020-05-21
 * @author 	rkddlsgur983
 * @idea	1번 마을부터의 경로 비용이 K이하인 마을의 개수를 구해야 하므로
 * 			다익스트라 알고리즘으로 1번 노드로부터의 최소 비용을 구한다.
 * 			그 중 특정 마을까지의 거리가 K를 넘어가면 다음에 구하는 모든 마을은 
 * 			K보다 크므로 탐색을 종료한다.
 */
public class PRO_L3_배달 {
	public int solution(int N, int[][] road, int K) {
        List<Road>[] graph = new List[N];
        for (int i = 0; i < N; ++i) {
        	graph[i] = new LinkedList<>();
        }
        for (int i = 0, len = road.length; i < len; ++i) {
        	int a = road[i][0]-1;
        	int b = road[i][1]-1;
        	int c = road[i][2];
        	graph[a].add(new Road(b,c));
        	graph[b].add(new Road(a,c));
        }
        
        PriorityQueue<Road> pq = new PriorityQueue<>();
        Road[] roads = new Road[N];
		for (int i = 0; i < N; ++i) {
			if (i == 0) {
				roads[i] = new Road(i, 0);
			} else {
				roads[i] = new Road(i, Integer.MAX_VALUE);
			}
			pq.add(roads[i]); 
		}
		int answer = 0;
		while (!pq.isEmpty()) {
			Road r = pq.poll();
			if (r.v <= K) {
				++answer;
			} else {
				break;
			}
			for (Road ro: graph[r.i]) {
				if (roads[ro.i].v > roads[r.i].v + ro.v) {
					roads[ro.i].v = roads[r.i].v + ro.v;
					pq.remove(roads[ro.i]);
					pq.add(roads[ro.i]);
				}
			}
		}
        return answer;
    }
	
	class Road implements Comparable<Road>{
		int i;
		int v;
		public Road(int i, int v) {
			this.i = i;
			this.v = v;
		}
		@Override
		public int compareTo(Road o) {
			return Integer.compare(v, o.v);
		}
	}
}
