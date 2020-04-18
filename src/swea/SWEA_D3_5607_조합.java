package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @memory 	27576KB / 256MB
 * @time   	141ms / 4초
 * @idea	페르마의 소정리 + 빠른 거듭제곱
 * 			https://nexters.me/vg
 */
public class SWEA_D3_5607_조합 {
	private static int MOD = 1234567891, N = 1000000;
	private static long[] fac = new long[N+1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		fac[1] = 1;
		for (int i = 2; i <= N; ++i) {
			fac[i] = (fac[i-1]*i)%MOD;
		}
		int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; ++t) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long ans = 1;
    		if (n != r && r > 0) {
    			ans = (fac[n]*pow((fac[n-r]*fac[r])%MOD, MOD-2))%MOD;
    		}
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
	}
	
	private static long pow(long base, int power) {
		
		long result = 1L;
		while (power > 0) {
			if ((power & 1)==1) {
				result = (result * base) % MOD;
			}
			power >>= 1;
			base = base * base % MOD;
		}
		return result;
	}
}
