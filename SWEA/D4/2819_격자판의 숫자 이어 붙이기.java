import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	private static int[][] di = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	private static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int[][] map = new int[4][4];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			set.clear();
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					int[] arr = new int[7];
					arr[0] = map[j][k];
					bruteForce(j, k, 1, map, arr);
				}
			}
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static void bruteForce(int row, int col, int cnt, int[][] map, int[] arr) {
		
		if (cnt == 7) {
			set.add(Arrays.toString(arr));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = row + di[i][0];
			int nc = col + di[i][1];
			if (isInRange(nr, nc)) {
				arr[cnt] = map[nr][nc];
				bruteForce(nr, nc, cnt+1, map, arr);
			}
		}
	}
	
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < 4 && col >= 0 && col < 4;
	}
}
