package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-05
 * @author ssafy
 * @memory 25548KB / 262144KB
 * @time   109ms / 2초
 */
public class SWEA_D4_1808_지희의고장난계산기_참고 {
	private static int X;
    private static int min;
    private static final boolean[] calc = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine().trim());
        for (int tc = 1; tc <= T; ++tc) {
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(bf.readLine().trim(), " ");
            for (int i = 0; i < 10; ++i) {
                calc[i] = Integer.parseInt(st.nextToken()) == 1;
            }
            X = Integer.parseInt(bf.readLine().trim());
            find(X, 0);
            min = min == Integer.MAX_VALUE ? -1: min;
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        bf.close();
    }
    private static int find(int x, int cnt) {
        if(isMake(String.valueOf(x))) {
            if(cnt == 0) {
                min = len(x)+1; // 계산 버튼 +1
            }
            return len(x)+1;
        }
        
        // result 값을 -1로 초기화 
        int result = -1;
        // 2~ 제곱근 까지 반복(i)
        for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; ++i) {
        	// i가 x의 약수이면서, 계산기를 눌러서 만들어질 수 있는 수인지 확인
            if(x % i == 0 && isMake(String.valueOf(i))) {
                // i의 길이를 구해고
                int len1 = len(i) + 1; // 곱하기 버튼 +1
                // 몫이 x의 약수이면서, 계산기를 눌러서 만들어질 수 있는 수인지 확인  ==> 재귀 호출 
                int len2 = find(x/i, cnt+1);
                //몫이 -1이 아니면  => 가능
                if(len2 > -1) {
                	// i의 길이와 몫의 길이를 더하고 min 갱신
                    result = len1 + len2;
                    if(result < min && x == X) {
                        min = result;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isMake(String x) {
        for (char c : x.toCharArray()) {
            if(!calc[c-'0']) {
                return false;
            }
        }
        return true;
    }
    
    private static int len(int x) {
        return (int)Math.log10(x)+1; // x의 길이
    }
}
