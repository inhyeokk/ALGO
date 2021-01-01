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
 * @date    2021-01-01
 * @author  lolol0705
 * @memory  74212KB / 256MB
 * @time    896ms / 1초
 */
public class BOJ_1504 {
    private static final int MAX = 2000;
    private static int n, e;
    private static List<Node>[] graph;
    private static int v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c)); // 1
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        br.close();

        int first = first(); // 2
        int second = second(); // 3
        System.out.print(Math.min(first, second)); // 4
    }

    // 1 -> v1 -> v2 -> N
    private static int first() {
        int dis = dijkstra(1, v1);
        if (dis == MAX) return -1;

        int temp = dijkstra(v1, v2);
        if (temp == MAX) return -1;
        dis += temp;

        temp = dijkstra(v2, n);
        if (temp == MAX) return -1;
        dis += temp;
        return dis;
    }

    // 1 -> v2 -> v1 -> N
    private static int second() {
        int dis = dijkstra(1, v2);
        if (dis == MAX) return -1;

        int temp = dijkstra(v2, v1);
        if (temp == MAX) return -1;
        dis += temp;

        temp = dijkstra(v1, n);
        if (temp == MAX) return -1;
        dis += temp;
        return dis;
    }

    private static int dijkstra(int start, int end) {
        Node[] nodes = new Node[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; ++i) {
            if (i == start) {
                nodes[i] = new Node(i, 0);
            } else {
                nodes[i] = new Node(i, MAX);
            }
            pq.add(nodes[i]);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node other: graph[node.i]) {
                if (nodes[other.i].v > node.v + other.v) {
                    nodes[other.i].v = node.v + other.v;
                    pq.remove(nodes[other.i]);
                    pq.add(nodes[other.i]);
                }
            }
        }
        return nodes[end].v;
    }

    private static class Node implements Comparable<Node> {
        int i;
        int v;

        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(v, o.v);
        }
    }
}
