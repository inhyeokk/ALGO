package programmers;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @{link}	https://programmers.co.kr/learn/courses/30/lessons/42895
 * @date   	2020-04-03
 * @author 	rkddlsgur983
 * @idea	N의 개수만큼 사용해서 만들 수 있는 수를 먼저 리스트에 저장
 * 			2 ~ 8까지 N 사용 범위를 늘려가면서 사직연산을 수행
 * 			number와 일치하면 현재 범위를 반환
 * 			마지막까지 찾지 못했다면 -1을 반환
 */
public class PRO_L3_N으로표현 {
	private final int M = 8;
	private final List<Integer>[] list = new List[M+1];
	private final Set<Integer> set = new HashSet<>();
	public int solution(int N, int number) {
		for (int i = 1, k = 0; i <= M; ++i) {
			list[i] = new LinkedList<>();
			k = k*10+N;
			if (k == number) return i;
			set.add(k);
			list[i].add(k);
		}
		
		for (int i = 2; i <= M; ++i) {
			for (int j = 1; j <= i-1; ++j) {
				int k = i-j;
				for (Integer a: list[j]) {
					for (Integer b: list[k]) {
						if (a+b==number) return i;
						else if (!set.contains(a+b)) {
							set.add(a+b);
							list[i].add(a+b);
						}
						if (a-b > 0) {
							if (a-b==number) return i;
							else if (!set.contains(a-b)) {
								set.add(a-b);
								list[i].add(a-b);
							}
						}
						if (a*b==number) return i;
						else if (!set.contains(a*b)) {
							set.add(a*b);
							list[i].add(a*b);
						}
						if (a/b > 0) {
							if (a/b==number) return i;
							else if (!set.contains(a/b)) {
								set.add(a/b);
								list[i].add(a/b);
							}
						}
						
						if (b-a > 0) {
							if (b-a==number) return i;
							else if (!set.contains(b-a)) {
								set.add(b-a);
								list[i].add(b-a);
							}
						}
						if (b/a > 0) {
							if (b/a==number) return i;
							else if (!set.contains(b/a)) {
								set.add(b/a);
								list[i].add(b/a);
							}
						}
					}
				}
			}
		}
		return -1;
    }
}
