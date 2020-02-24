import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			int ans = 0;
			for (int j = 0; j < 100; j++) {
				boolean magnet = false; // 0: x, 1: n, 2: s
				for (int k = 0; k < 100; k++) {
					if (!magnet && map[k][j] == 1) {
						magnet = true;
					} else if (magnet && map[k][j] == 2){
						magnet = false;
						ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
