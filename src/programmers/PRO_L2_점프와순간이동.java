package programmers;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12980
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	목적지에서 출발지까지 최소한의 비용으로 이동하는 것과 같음
 * 			n이 짝수이면 순간이동 / 홀수이면 1만큼 비용을 들여 이동
 */
public class PRO_L2_점프와순간이동 {
	public int solution(int n) {
        int ans = 0;
        while (n > 0) {
        	if (n % 2 == 0) {
        		n /= 2;
        	} else {
        		--n;
        		++ans;
        	}
        }
        return ans;
    }
}
