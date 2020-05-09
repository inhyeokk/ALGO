package programmers.kakao.intern2020;
import java.util.LinkedList;
import java.util.Queue;

class Solution4 {
    private int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] weight = new int[n][n][4];
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0,0,0));
        q.add(new Move(0,0,1));
        weight[0][0][0] = 100;
        weight[0][0][1] = 100;
        while (!q.isEmpty()) {
            Move m = q.poll();
            for (int d = 0; d < 4; ++d) {
                int nr = m.r + di[d][0];
                int nc = m.c + di[d][1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == 0) {
                    int nv = weight[m.r][m.c][m.d] + (m.d == d ? 100 : 600);
                    if (weight[nr][nc][d] == 0 || weight[nr][nc][d] >= nv) {
                        weight[nr][nc][d] = nv;
                        if (nr != n-1 || nc != n-1) {
                            q.add(new Move(nr,nc,d));
                        }
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; ++i) {
        	if (weight[n-1][n-1][i] == 0) continue;
        	answer = Math.min(weight[n-1][n-1][i], answer);
        }
        return answer-100;
    }

    class Move {
        int r;
        int c;
        int d;

        public Move(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}