package programmers;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/42898
 * @date   	2020-05-09
 * @author 	rkddlsgur983
 * @idea	동적 계획법
 */
public class PRO_L3_등굣길 {
	private int mod = 1000000007;
	public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for (int[] p: puddles) {
        	map[p[1]-1][p[0]-1] = -1;
        }
        for (int i = 0; i < m; ++i) {
        	if (map[0][i] == -1) break;
        	map[0][i] = 1;
        }
        for (int i = 0; i < n; ++i) {
        	if (map[i][0] == -1) break;
        	map[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
        	for (int j = 1; j < m; ++j) {
        		if (map[i][j] == -1) continue;
        		if (map[i-1][j] != -1) {
        			map[i][j] = (map[i][j] + map[i-1][j])%mod;
        		}
        		if (map[i][j-1] != -1) {
        			map[i][j] = (map[i][j] + map[i][j-1])%mod;
        		}
        	}
        }
		int answer = map[n-1][m-1];
        return answer;
    }
}
