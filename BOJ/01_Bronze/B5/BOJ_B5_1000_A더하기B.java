import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1000
 * @date   	2020-04-01
 * @author 	rkddlsgur983
 * @memory 	12908KB / 128MB
 * @time   	76ms / 2초
 * @idea	단순계산
 */
public class BOJ_B5_1000_A더하기B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.print(a+b);
		br.close();
	}
}
