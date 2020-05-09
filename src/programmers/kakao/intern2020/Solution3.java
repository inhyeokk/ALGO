package programmers.kakao.intern2020;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	public int[] solution(String[] gems) {
		Map<String, Integer> map = new HashMap<>();
		int n = 0, len = gems.length;
		for (String s: gems) {
			if (!map.containsKey(s))
				map.put(s, n++);
		}
        int[] answer = {0, len-1};
        int curlen = len-1;
		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		for (int i = 0; i < len; ++i) {
			arr[map.get(gems[i])] = i;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; ++j) {
				if (arr[j] == -1) {
					min = -1;
					break;
				}
				min = Math.min(arr[j], min);
			}
			if (min != -1) {
				if (i - min < curlen) {
					answer[0] = min;
					answer[1] = i;
					curlen = i-min;
				}
			}
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}
		if (max-min < curlen) {
			answer[0] = min;
			answer[1] = max;
		}
		++answer[0];
		++answer[1];
        return answer;
    }
}
