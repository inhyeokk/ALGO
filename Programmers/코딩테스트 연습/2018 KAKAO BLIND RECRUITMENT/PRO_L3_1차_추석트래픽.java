import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @{link} https://programmers.co.kr/learn/courses/30/lessons/17676
 * @date   2020-03-23
 * @author rkddlsgur983
 */
public class PRO_L3_1차_추석트래픽 {
	public static int solution(String[] lines) {
        StringTokenizer st, st2, st3;
        int size = lines.length;
        Process[] parr = new Process[size];
        for (int i = 0 ; i < size; ++i) {
            st = new StringTokenizer(lines[i], " ");
            st.nextToken(); // 2016-09-15

            // 시분초 -> 초
            String time = st.nextToken();
            st2 = new StringTokenizer(time, ":,.");
            double sec = Integer.parseInt(st2.nextToken())*60*60;
            sec += Integer.parseInt(st2.nextToken())*60;
            sec += Integer.parseInt(st2.nextToken());
            sec += Integer.parseInt(st2.nextToken())/1000.0;

            // 처리시간
            String durings = st.nextToken();
            double during = 0.0;
            if (durings.contains(".")) {
                st3 = new StringTokenizer(durings, ".");
                during += Integer.parseInt(st3.nextToken());
                String tmp = st3.nextToken();
                during += Integer.parseInt(tmp.substring(0, tmp.length()-1))/1000.0;
            } else {
                during += Integer.parseInt(durings.substring(0, durings.length()-1));
            }    
            parr[i] = new Process(sec < during ? 0 : sec-during, sec);
        }
        
        Arrays.sort(parr);
        int answer = 1;
        for (int i = 0; i < size-1; ++i) {
            int cnt = 1;
            for (int j = i+1; j < size; ++j) {
                if (parr[i].end+0.998 >= parr[j].start) {
                    ++cnt;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    static class Process implements Comparable<Process> {
        double start;
        double end;

        public Process(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Process o) {
            return Double.compare(end, o.end);
        }
    }
}
