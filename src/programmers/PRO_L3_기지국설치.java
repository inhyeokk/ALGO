package programmers;

/**
 * @source	Summer/Winter Coding(~2018)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/12979
 * @date   	2020-05-21
 * @author 	rkddlsgur983
 * @idea	하단 참조
 */
public class PRO_L3_기지국설치 {
	public int solution(int n, int[] stations, int w) {
		/* left: 현재 기지국(i) 기준 왼쪽의 가장 가까운 전파가 닿는 위치
		 * v: 한개의 기지국의 전파가 닿는 범위
		 */
        int answer = 0, left = 0, v = w*2+1;
        for (int i = 0, len = stations.length; i < len; ++i) {
        	/* 현재의 기지국 기준 왼쪽에 전파가 닿지 않는 아파트 수(t)가 있다면
        	 * (t-1)/v+1은 최소로 필요한 기지국의 수와 같다.
        	 */
        	int t = stations[i]-w-1-left;
        	if (t > 0) {
            	answer += (t-1)/v+1;
        	}
        	left = stations[i]+w;
        }
        if (n-left > 0) {
            answer += (n-left-1)/v+1;
        }
        return answer;
    }
}
