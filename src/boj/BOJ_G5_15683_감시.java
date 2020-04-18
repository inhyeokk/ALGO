package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-03
 * @author rkddlsgur983
 * @memory 45976KB / 512MB
 * @time   208ms / 1초
 */
public class BOJ_G5_15683_감시 {
	private static int[][] map, cctv;
	private static int n, m, cidx, min;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cctv = new int[8][2];
		cidx = 0;
		int invisible = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					++invisible;
				} else if (map[i][j] != 6){
					cctv[cidx][0] = i;
					cctv[cidx++][1] = j;
				}
			}
		}
		min = invisible;
		dfs(0, invisible);
		System.out.print(min);
		bf.close();
	}
	
	private static void dfs(int idx, int invisible) {
		
		if (idx == cidx) {
			min = min > invisible ? invisible : min;
			return;
		}
		
		int[][] tmap = new int[n][m];
		for (int i = 0; i < n; ++i) {
			tmap[i] = map[i].clone();
		}
		
		int row = cctv[idx][0];
		int col = cctv[idx][1];
		switch (map[row][col]) {
			case 1: 
				dfs(idx+1, invisible-a(row,col));
				for (int i = col+1; i < m; ++i)
					map[row][i] = tmap[row][i];
				
				dfs(idx+1, invisible-b(row,col));
				for (int i = row+1; i < n; ++i)
					map[i][col] = tmap[i][col];
				
				dfs(idx+1, invisible-c(row,col));
				for (int i = 0; i < col; ++i)
					map[row][i] = tmap[row][i];
				
				dfs(idx+1, invisible-d(row,col));
				for (int i = 0; i < row; ++i)
					map[i][col] = tmap[i][col];
				return;
			case 2:
				dfs(idx+1, invisible-a(row,col)-c(row,col));
				map[row] = tmap[row].clone();
				
				dfs(idx+1, invisible-b(row,col)-d(row,col));
				for (int i = 0; i < n; ++i)
					map[i][col] = tmap[i][col];
				return;
			case 3:
				dfs(idx+1, invisible-a(row,col)-b(row,col));
				for (int i = col+1; i < m; ++i)
					map[row][i] = tmap[row][i];
				for (int i = row+1; i < n; ++i)
					map[i][col] = tmap[i][col];
				
				dfs(idx+1, invisible-b(row,col)-c(row,col));
				for (int i = row+1; i < n; ++i)
					map[i][col] = tmap[i][col];
				for (int i = 0; i < col; ++i)
					map[row][i] = tmap[row][i];
				
				dfs(idx+1, invisible-c(row,col)-d(row,col));
				for (int i = 0; i < col; ++i)
					map[row][i] = tmap[row][i];
				for (int i = 0; i < row; ++i)
					map[i][col] = tmap[i][col];
				
				dfs(idx+1, invisible-d(row,col)-a(row,col));
				for (int i = 0; i < row; ++i)
					map[i][col] = tmap[i][col];
				for (int i = col+1; i < m; ++i)
					map[row][i] = tmap[row][i];
				return;
			case 4:
				dfs(idx+1, invisible-a(row,col)-b(row,col)-c(row,col));
				map[row] = tmap[row].clone(); // a,c
				for (int i = row+1; i < n; ++i) // b
					map[i][col] = tmap[i][col];
				
				dfs(idx+1, invisible-b(row,col)-c(row,col)-d(row,col));
				for (int i = 0; i < n; ++i) // b,d
					map[i][col] = tmap[i][col];
				for (int i = 0; i < col; ++i) // c
					map[row][i] = tmap[row][i];
				
				dfs(idx+1, invisible-c(row,col)-d(row,col)-a(row,col));
				map[row] = tmap[row].clone(); // a,c
				for (int i = 0; i < row; ++i) // d
					map[i][col] = tmap[i][col];
				
				dfs(idx+1, invisible-d(row,col)-a(row,col)-b(row,col));
				for (int i = 0; i < n; ++i) // b,d
					map[i][col] = tmap[i][col];
				for (int i = col+1; i < m; ++i) // a
					map[row][i] = tmap[row][i];
				return;
			case 5:
				dfs(idx+1, invisible-a(row,col)-b(row,col)-c(row,col)-d(row,col));
				map[row] = tmap[row].clone();
				for (int i = 0; i < n; ++i)
					map[i][col] = tmap[i][col];
				return;
		}
	}
	
	private static int a(int row, int col) {
		int nc = col+1;
		int sum = 0;
		while (nc < m && map[row][nc] != 6) {
			if (map[row][nc] == 0) {
				map[row][nc] = -1;
				++sum;
			}
			++nc;
		}
		return sum;
	}
	
	private static int b(int row, int col) {
		int nr = row+1;
		int sum = 0;
		while (nr < n && map[nr][col] != 6) {
			if (map[nr][col] == 0) {
				map[nr][col] = -1;
				++sum;
			}
			++nr;
		}
		return sum;
	}
	
	private static int c(int row, int col) {
		int nc = col-1;
		int sum = 0;
		while (nc >= 0 && map[row][nc] != 6) {
			if (map[row][nc] == 0) {
				map[row][nc] = -1;
				++sum;
			}
			--nc;
		}
		return sum;
	}
	
	private static int d(int row, int col) {
		int nr = row-1;
		int sum = 0;
		while (nr >= 0 && map[nr][col] != 6) {
			if (map[nr][col] == 0) {
				map[nr][col] = -1;
				++sum;
			}
			--nr;
		}
		return sum;
	}
}
