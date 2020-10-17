package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * {@link}  https://www.acmicpc.net/problem/19238
 * @date    2020-10-18
 * @author  lolol0705
 * @memory  25212KB / 512MB
 * @time    304ms / 1초
 * @comment 극한의 시뮬레이션
 */
public class BOJ_19238 {
    private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken()); // 초기 연료의 양
        int[][] map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 지도
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int sr = Integer.parseInt(st.nextToken()) - 1; // 택시의 시작 위치
        int sc = Integer.parseInt(st.nextToken()) - 1;

        Passenger[] passengers = new Passenger[m];
        for (int i = 0; i < m; ++i) { // 손님의 위치
            st = new StringTokenizer(br.readLine(), " ");
            int psr = Integer.parseInt(st.nextToken()) - 1;
            int psc = Integer.parseInt(st.nextToken()) - 1;
            map[psr][psc] = i+2; // 손님 시작 위치에 손님 인덱스+2 저장
            int per = Integer.parseInt(st.nextToken()) - 1;
            int pec = Integer.parseInt(st.nextToken()) - 1;
            passengers[i] = new Passenger(psr, psc, per, pec);
        }
        br.close();

        PriorityQueue<Passenger> pq = new PriorityQueue<>((o1, o2) -> { // 태울 수 있는 승객 조건 처리
            if (o1.sr == o2.sr) {
                return Integer.compare(o1.sc, o2.sc);
            } else {
                return Integer.compare(o1.sr, o2.sr);
            }
        });

        int complete = 0;
        while (complete < m) {
            ++complete;
            if (map[sr][sc] >= 2) { // 택시 출발 위치와 승객 위치가 같은경우
                Passenger p = passengers[map[sr][sc]-2];
                int mf = bfs(n, map, p.sr, p.sc, p.er, p.ec, fuel); // 승객을 태우고 이동하면서 사용한 연료
                if (mf == -1) {
                    System.out.print(-1);
                    return;
                } else {
                    fuel += mf; // 연료 충전
                    map[p.sr][p.sc] = 0; // 다음 이동을 위한 초기화
                    sr = p.er;
                    sc = p.ec;
                }
            } else { // 택시 출발 위치와 다르므로 승객을 태우기 위한 이동
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {sr,sc}); // 택시 시작 위치
                boolean[][] visit = new boolean[n][n];
                visit[sr][sc] = true; // 시작 위치 방문 체크

                while (!q.isEmpty()) { // 최단거리의 승객 탐색 BFS
                    --fuel;
                    if (fuel == 0) { // 연료 X
                        System.out.print(-1);
                        return;
                    }

                    int size = q.size();
                    for (int i = 0; i < size; ++i) {
                        int[] move = q.poll();
                        int r = move[0];
                        int c = move[1];
                        for (int[] d: di) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] != 1) {
                                visit[nr][nc] = true;
                                if (map[nr][nc] >= 2) { // 승객 출발 위치
                                    pq.add(passengers[map[nr][nc]-2]);
                                } else { // 활동영역
                                    q.add(new int[] {nr, nc});
                                }
                            }
                        }
                    }

                    if (pq.isEmpty() && q.isEmpty()) { // 아무도 못태움
                        System.out.print(-1);
                        return;
                    }

                    if (!pq.isEmpty()) { // 승객 이동
                        Passenger p = pq.poll();
                        int mf = bfs(n, map, p.sr, p.sc, p.er, p.ec, fuel); // 승객을 태우고 이동하면서 사용한 연료
                        if (mf == -1) {
                            System.out.print(-1);
                            return;
                        } else {
                            fuel += mf; // 연료 충전
                            map[p.sr][p.sc] = 0; // 다음 이동을 위한 초기화
                            sr = p.er;
                            sc = p.ec;
                        }
                        q.clear(); // 승객을 태웠으니 현재 스탭 종료
                        pq.clear();
                    }
                }
            }
        }
        System.out.print(fuel); // 성공했다면 남은 연료
    }

    private static int bfs(int n, int[][] map, int sr, int sc, int er, int ec, int fuel) {
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        boolean[][] visit = new boolean[n][n];
        visit[sr][sc] = true;

        while (!q.isEmpty()) {
            ++step;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] move = q.poll();
                int r = move[0];
                int c = move[1];
                for (int[] d: di) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] != 1 && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        if (nr == er && nc == ec) {
                            return step;
                        }
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            if (fuel == step) return -1;
        }
        return -1;
    }

    private static class Passenger {
        int sr;
        int sc;
        int er;
        int ec;
        public Passenger(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }
}
