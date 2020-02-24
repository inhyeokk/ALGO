import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	
	private static int[][] horse = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] map = new int[w][h];
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < h; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int[][][] weight = new int[w][h][k+1];
		queue.add(0); // row
		queue.add(0); // col
		queue.add(0); // weight
		queue.add(0); // horse
		int result = -1;
		here: while(!queue.isEmpty()) {
			int row = queue.poll();
			int col = queue.poll();
			int wei = queue.poll();
			int hor = queue.poll();
			if (hor < k) {
				for (int i = 0; i < horse.length; i++) {
					int nr = row + horse[i][0];
					int nc = col + horse[i][1];
					if (!isInRange(nr,nc,w,h) || map[nr][nc] != 0) {
						continue;
					}
					if (nr == w-1 && nc == h-1) {
						result = wei+1;
						break here;
					}
					int tw = weight[nr][nc][hor+1];
					if (tw == 0 || tw > wei+1) {
						weight[nr][nc][hor+1] = wei+1;
						queue.add(nr);
						queue.add(nc);
						queue.add(wei+1);
						queue.add(hor+1);
					}
				}
			}
			for (int i = 0; i < di.length; i++) {
				int nr = row + di[i][0];
				int nc = col + di[i][1];
				if (!isInRange(nr,nc,w,h) || map[nr][nc] != 0) {
					continue;
				}
				if (nr == w-1 && nc == h-1) {
					result = wei+1;
					break here;
				}
				int tw = weight[nr][nc][hor];
				if (tw == 0 || tw > wei+1) {
					weight[nr][nc][hor] = wei+1;
					queue.add(nr);
					queue.add(nc);
					queue.add(wei+1);
					queue.add(hor);
				}
			}
		}
		System.out.print(result);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int w, int h) {
		return row >= 0 && row < w && col >= 0 && col < h;
	}
}