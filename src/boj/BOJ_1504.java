package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/1504
 * @date    2021-01-03
 * @author  lolol0705
 * @memory  70456KB / 256MB
 * @time    600ms / 1초
 */
public class BOJ_1504 {
    private static final int MAX = 2000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c)); // 1
            graph[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        br.close();

        Edge[] v1_edges = dijkstra(graph, n, v1);
        Edge[] v2_edges = dijkstra(graph, n, v2);

        if (v1_edges[1].v == MAX || v1_edges[v2].v == MAX || v2_edges[n].v == MAX
                || v2_edges[1].v == MAX || v2_edges[v1].v == MAX || v1_edges[n].v == MAX) {
            System.out.print(-1);
        } else {
            // 1 -> v1 -> v2 -> N
            int first = v1_edges[1].v + v1_edges[v2].v + v2_edges[n].v; // 2
            // 1 -> v2 -> v1 -> N
            int second = v2_edges[1].v + v2_edges[v1].v + v1_edges[n].v; // 3
            System.out.print(Math.min(first, second)); // 4
        }
    }

    private static Edge[] dijkstra(List<Edge>[] graph, int n, int start) {
        Edge[] edges = new Edge[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; ++i) {
            if (i == start) {
                edges[i] = new Edge(i, 0);
            } else {
                edges[i] = new Edge(i, MAX);
            }
            pq.add(edges[i]);
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            for (Edge other: graph[edge.i]) {
                if (edges[other.i].v > edge.v + other.v) {
                    edges[other.i].v = edge.v + other.v;
                    pq.remove(edges[other.i]);
                    pq.add(edges[other.i]);
                }
            }
        }
        return edges;
    }

    static class Edge implements Comparable<Edge> {
        int i;
        int v;

        public Edge(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(v, o.v);
        }
    }
}
