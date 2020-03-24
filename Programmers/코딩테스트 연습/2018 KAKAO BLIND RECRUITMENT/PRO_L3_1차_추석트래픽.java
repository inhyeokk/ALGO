import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @{link} 	https://programmers.co.kr/learn/courses/30/lessons/17676
 * @date   	2020-03-23
 * @author 	rkddlsgur983
 * @idea	값 비교시 Double형 보다 Integer형이 더 안정적임
 */
public class PRO_L3_1차_추석트래픽 {
	public int solution(String[] lines) {
        StringTokenizer st;
        int size = lines.length;
        Process[] parr = new Process[size];
        for (int i = 0 ; i < size; ++i) {
            st = new StringTokenizer(lines[i], " :.s");
            st.nextToken(); // 2016-09-15

            // 시분초 -> 초
            int sec = Integer.parseInt(st.nextToken())*60*60;
            sec += Integer.parseInt(st.nextToken())*60;
            sec += Integer.parseInt(st.nextToken());
            sec *= 1000;
            sec += Integer.parseInt(st.nextToken());

            // 처리시간
            int during = Integer.parseInt(st.nextToken())*1000;
            if (st.hasMoreTokens()) {
            	during += Integer.parseInt(st.nextToken());
            }
            parr[i] = new Process(sec < during ? 0 : sec-during, sec);
        }
        
        Arrays.sort(parr);
        int answer = 1;
        for (int i = 0; i < size-1; ++i) {
            int cnt = 1;
            for (int j = i+1; j < size; ++j) {
                if (parr[i].end+988 >= parr[j].start) {
                    ++cnt;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    class Process implements Comparable<Process> {
        int start;
        int end;

        public Process(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Process o) {
            return Integer.compare(end, o.end);
        }
    }
}
