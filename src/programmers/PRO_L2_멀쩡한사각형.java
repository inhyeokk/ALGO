package programmers;

/**
 * @source	Summer/Winter Coding(2019)
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/62048
 * @date   	2020-05-20
 * @author 	rkddlsgur983
 * @idea	최대공약수 g에 대한 
 * 			1. a = w/g
 * 			2. b = h/g
 * 			일때 대각선을 만나는 사각형의 수는 a+b-1이다.
 * 			이 경우가 g만큼 반복되므로 전체 개수에서 빼준다.
 */
public class PRO_L2_멀쩡한사각형 {
	public long solution(int w, int h) {
        long answer = (long)w * (long)h;
        int g = gcd(w,h);
        int a = w/g;
        int b = h/g;
        answer -= (a+b-1)*g;
        return answer;
    }
	
	private int gcd(int a, int b) {
		while (b > 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
}
