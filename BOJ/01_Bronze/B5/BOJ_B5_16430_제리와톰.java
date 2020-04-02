import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/16430
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @memory 	12888KB / 128MB
 * @time   	72ms / !초
 * @idea	유클리드 호제법 최대공약수
 */
public class BOJ_B5_16430_제리와톰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int p = b-a;
		int g = gcd(b, p);
		System.out.print(p/g+" "+b/g);
	}
	
	// gcd(a,b) = gcd(b,r)
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
