package programmers;
import java.util.Arrays;

class PRO_L2_프린터 {
    public int solution(int[] priorities, int location) {
        
    	int index = 0;
    	int cnt = 1;
    	int[] print = new int[priorities.length];
    	
    	while (cnt <= priorities.length) {
    		int max = Arrays.stream(priorities).max().getAsInt();
    		if (max == priorities[index]) {
				print[index] = cnt++;
				priorities[index] = 0;
			}
    		index++;
    		if (index == priorities.length) {
    			index = 0;
    		}
    	}
    	
    	int answer = print[location];
        return answer;
    }
}