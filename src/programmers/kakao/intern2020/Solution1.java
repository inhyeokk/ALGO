package programmers.kakao.intern2020;

public class Solution1 {
	private static final int[][] dis= {
			{1,2,3,4},{2,1,2,3},{3,2,1,2},{4,3,2,1},
			{0,1,2,3},{1,0,1,2},{2,1,0,1},{3,2,1,0}
	};
	public String solution(int[] numbers, String hand) {
		int left = 3, right = 3;
        String answer = "";
		for (int i = 0, len = numbers.length; i < len; ++i) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				left = getIndex(numbers[i]);
				answer += 'L';
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				right = getIndex(numbers[i]);
				answer += 'R';
			} else {
				int center = getCenter(numbers[i]);
				int ld = dis[left][center];
				int rd = dis[right][center];
				if (ld == rd) {
					if ("left".equals(hand)) {
						left = getIndex(numbers[i]);
						answer += 'L';
					} else {
						right = getIndex(numbers[i]);
						answer += 'R';
					}
				} else if (ld < rd) {
					left = getIndex(numbers[i]);
					answer += 'L';
				} else {
					right = getIndex(numbers[i]);
					answer += 'R';
				}
			}
		}
        return answer;
    }
	
	private int getCenter(int n) {
		switch (n) {
			case 2: return 0;
			case 5: return 1;
			case 8: return 2;
			case 0: return 3;
		}
		return 0;
	}
	
	private int getIndex(int n) {
		switch (n) {
			case 1: return 0;
			case 3: return 0;
			case 4: return 1;
			case 6: return 1;
			case 7: return 2;
			case 9: return 2;
			case 2: return 4;
			case 5: return 5;
			case 8: return 6;
			case 0: return 7;
		}
		return 0;
	}
}
