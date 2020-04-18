package programmers;

/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/43105
 * @date   2020-04-02
 * @author rkddlsgur983
 */
public class PRO_L3_정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = triangle[0][0];
        for (int i = 1, len = triangle.length; i < len; ++i) {
        	int ilen = triangle[i-1].length-1;
        	int jlen = triangle[i].length-1;
        	triangle[i][0] += triangle[i-1][0];
        	answer = Math.max(triangle[i][0], answer);
        	triangle[i][jlen] += triangle[i-1][ilen];
        	answer = Math.max(triangle[i][jlen], answer);
        	for (int j = 1; j < jlen; ++j) {
        		triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            	answer = Math.max(triangle[i][j], answer);
        	}
        }
		return answer;
    }
}
